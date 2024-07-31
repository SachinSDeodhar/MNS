package com.mns.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public static String readProperty(String filepath, String key) {
		FileInputStream fis=null;
		String value="";
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop =new Properties();
		try {
			prop.load(fis) ;
			value=prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
