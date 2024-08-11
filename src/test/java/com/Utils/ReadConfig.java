package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties properties=new Properties();
	FileInputStream fis;
	String path="F:\\SwagLabs\\Properties\\Config.properties";
	
	public ReadConfig()
	{
		 try {
			fis=new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String GetUrl()
	{
		String url=properties.getProperty("url");
		if(url!=null) {
			return url;
		}else {
			throw new RuntimeException("Not Get URL From Property file");
		}
	}
	public String GetUname()
	{
		String uname=properties.getProperty("uname");
		if(uname!=null) {
			return uname;
		}else {
			throw new RuntimeException("User name not get from properties file");
		}
	}
	public String GetPassword()
	{
		String password=properties.getProperty("password");
		if(password!=null) {
			return password;
		}else {
			throw new RuntimeException("Password not getting from properties file");
		}
	}
}
