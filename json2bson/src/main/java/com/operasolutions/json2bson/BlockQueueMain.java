package com.operasolutions.json2bson;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

public class BlockQueueMain {
	private static Logger logger = Logger.getLogger(BlockQueueMain.class);

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		if (!(args.length == 5 || args.length == 4)) {
			logger.error("invalid input parameters");
			throw new RuntimeException("invalid input parameters");

		}
		logger.info("start_time:"
				+ new Timestamp(Calendar.getInstance().getTimeInMillis()));
		long startTime = System.currentTimeMillis();
		logger.info("json directory:" + args[0] + " bson file location:"
				+ args[1] + "hdfs tracker:" + args[2] + "hdfs name:" + args[3]);
		String outSuffix = ".bson";
		List<Path> allFiles = new ArrayList<Path>();
		String dir = args[0];
		String outFile = args[1];
		String track = args[2];
		String name = args[3];
		int threadNum = 0;
		if (args.length == 5) {
			threadNum = Integer.valueOf(args[4]);
			logger.info("read threads number:" + args[4]);
		}
		File file = new File(outFile);
		if (file.exists()) {
			file.delete();
		} else if (file.isFile() && !file.getPath().endsWith(outSuffix)) {
			logger.error("the name of output bson file is invalid");
			throw new RuntimeException(
					" the name of output file is invalid, please input another file name	");
		}
		FileSystem srcFS;
		try {
			srcFS = FileSystem.get(getConf(track, name));

			GetHdfsName fileList = new GetHdfsName();
			fileList.setDir(dir);
			fileList.setKeywords("part");
			fileList.setSrcFS(srcFS);
			fileList.setAllFiles(allFiles);
			fileList.run();
			logger.info("all json files:" + allFiles.toString() + "size:"
					+ allFiles.size());
			MultiThreadJsonReadAndConvertBlockingQueue
					.setCount(allFiles.size());
			ExecutorService exec = null;
			if (threadNum == 0) {
				exec = Executors.newCachedThreadPool();
			} else {
				exec = Executors.newFixedThreadPool(threadNum);
			}
			logger.info("output file:" + outFile);
			file.createNewFile();
			BlockingQueue<Object> que = new LinkedBlockingQueue<Object>();
			BlockingQueue<String> path = new LinkedBlockingQueue<String>();
			for (int i = 0; i < allFiles.size(); i++) {
				exec.execute(new MultiThreadJsonReadAndConvertBlockingQueue(
						allFiles.get(i), que, srcFS, path));
			}

			Thread writThread = new Thread(
					new SingleThreadWriteBsonBlockingQueue(outFile, que));
			writThread.setPriority(Thread.MAX_PRIORITY);
			writThread.start();
			writThread.join();
			long endTime = System.currentTimeMillis();

			logger.info("end_time:"
					+ new Timestamp(Calendar.getInstance().getTimeInMillis()));
			logger.info("total time:" + (endTime - startTime) + "ms");
			srcFS.close();
			exec.shutdown();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Configuration getConf(String tracker, String name) {

		Configuration conf = new Configuration();
		conf.set("mapred.job.tracker", tracker);
		conf.set("fs.default.name", name);
		return conf;
	}

}
