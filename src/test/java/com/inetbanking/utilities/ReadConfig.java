package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/Config.properties");
		
		try {		
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.print("Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseurl");
		return url;
	}
	
	public String getUserName() {
		String userName = pro.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFireFoxPath() {
		String firefoxPath = pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getIEPath() {
		String iePath = pro.getProperty("iepath");
		return iePath;
	}

}
