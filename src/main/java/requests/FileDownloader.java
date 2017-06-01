package main.java.requests;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileDownloader {

	public void download(String path)
	{
		String fromFile = "https://www.quandl.com/api/v3/databases/SF0/data?auth_token=mhShoedWJ1-5tAYWPjD9";
        String toFile = "C:\\work\\eclipse\\maven\\myFile.csv";

//        try {
//
//            //connectionTimeout, readTimeout = 10 seconds
//          //  FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 10000, 10000);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
	}
}
