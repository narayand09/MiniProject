package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(src);
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Exception is  "+e.getMessage());
		}
	}

	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String user=prop.getProperty("username");
		return user;
	}
	public String getPassword()
	{
		String pass=prop.getProperty("password");
		return pass;
	}
	
	public String getChroPath()
	{
		String ChPath=prop.getProperty("chromepath");
		return ChPath;
	}
	
	public String getFFPath()
	{
		String FFPath=prop.getProperty("firefoxpath");
		return FFPath;
	}
	public String getIEPath()
	{
		String IEPath=prop.getProperty("IEPath");
		return IEPath;
	}
}
