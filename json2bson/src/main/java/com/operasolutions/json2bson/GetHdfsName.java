package com.operasolutions.json2bson;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class GetHdfsName {

	private FileSystem srcFS;
	private String dir;
	private List<Path> allFiles;
	private String keywords;

	GetHdfsName() throws IOException {

	}

	public void run() {

		Path pt = new Path(dir);
		FileStatus contents[];
		try {
			contents = srcFS.listStatus(pt);
			for (int i = 0; i < contents.length; i++) {
				System.out.println(contents[i].getPath().getName());
				if (contents[i].getPath().getName().contains(keywords)) {
					allFiles.add(contents[i].getPath());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Path> getAllFiles() {
		return allFiles;
	}

	public void setSrcFS(FileSystem srcFS) {
		this.srcFS = srcFS;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setAllFiles(List<Path> allFiles) {
		this.allFiles = allFiles;
	}

}
