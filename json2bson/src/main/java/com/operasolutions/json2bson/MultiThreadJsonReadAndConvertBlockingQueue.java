package com.operasolutions.json2bson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;
import org.bson.BSONEncoder;
import org.bson.BasicBSONEncoder;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class MultiThreadJsonReadAndConvertBlockingQueue implements Runnable {
	private Path inputFile;
	private BlockingQueue<Object> queue;
	private BlockingQueue<String> pathQue;
	private static int count = 0;
	private BufferedReader fInput = null;
	private BSONEncoder bsonEnc = new BasicBSONEncoder();
	private static Logger logger = Logger
			.getLogger(MultiThreadJsonReadAndConvertBlockingQueue.class);
	static byte[] endPoint = "END".getBytes();

	public MultiThreadJsonReadAndConvertBlockingQueue(Path file,
			BlockingQueue<Object> que, FileSystem srcFS,
			BlockingQueue<String> qPath) throws IOException {
		super();
		logger.info("MultiThreadJsonReadAndConvert ["
				+ Thread.currentThread().getId() + "] (" + file + ") starting ");
		this.inputFile = file;
		fInput = new BufferedReader(
				new InputStreamReader(srcFS.open(inputFile)));
		this.queue = que;
		this.pathQue = qPath;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			logger.info("start to read file:" + inputFile + " running ");
			String info;
			int readCount = 0;
			while ((info = fInput.readLine()) != null) {
				readCount++;

				DBObject toEncode = (DBObject) JSON.parse(info);
				byte[] outputByteBuf = bsonEnc.encode(toEncode);
				queue.put(outputByteBuf);
				if (readCount % 1000 == 0) {
					logger.info("read thread retrieval: buffer size:"
							+ queue.size());
				}
			}
			logger.info(inputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			synchronized (fInput) {
				try {
					fInput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			logger.info("Thread [" + Thread.currentThread().getId()
					+ "] is ended, fileName:" + inputFile.getName());
			pathQue.add(inputFile.getName());
			if (pathQue.size() == MultiThreadJsonReadAndConvertBlockingQueue
					.getCount()) {
				try {
					queue.put(endPoint);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public synchronized static int getCount() {
		return count;
	}

	public synchronized static void setCount(int total) {
		count = total;
	}

}
