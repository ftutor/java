package com.operasolutions.json2bson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public class SingleThreadWriteBsonBlockingQueue implements Runnable {

	private String outFile;
	File file;
	private BlockingQueue<Object> queue;
	private FileOutputStream fOutput = null;
	static byte[] endPoint = "END".getBytes();
	private static Logger logger = Logger
			.getLogger(SingleThreadWriteBsonBlockingQueue.class);

	public SingleThreadWriteBsonBlockingQueue(String out,
			BlockingQueue<Object> que) throws IOException {
		super();
		this.outFile = out;
		file = new File(outFile);
		if (!file.exists()) {
			file.createNewFile();
		}
		fOutput = new FileOutputStream(outFile, true);
		this.queue = que;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			logger.info("write thread is :" + Thread.currentThread().getId()
					+ " running,outputfile: " + outFile);
			int writeCount = 0;

			while (true) {
				byte[] temp = (byte[]) queue.take();
				if (Arrays.equals(temp, endPoint)) {
					break;
				}
				// logger.info("reading successfully");
				fOutput.write(temp);
				writeCount++;
				if (writeCount % 5000 == 0) {
					logger.info("write thread retrieve bufferSize:"
							+ queue.size());

				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			synchronized (fOutput) {
				try {
					fOutput.flush();
					logger.info("file size:" + file.length());
					fOutput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
