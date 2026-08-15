package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManagerOLD {
//WAP to read the properties files from src/test/resource/config/config.properties
	private static Properties prop = new Properties();
	
	private ConfigManagerOLD() {
		//Private Constructor!!
	}
	static {
		// operation of Loading the properties file in the memory!
		// Static block execute will execute ! during class loding time
		File configFile = new File(
				System.getProperty("user.dir") + File.separator+"src"+ File.separator+"test"+ File.separator+"resources"+
		File.separator+"config"+ File.separator+"config.properties");

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(configFile);
			prop.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {

		//Create the object of the Properties class
		
		// Load the properties file using the load()
		System.out.println(prop.getProperty("BASE_URI"));
		return prop.getProperty(key);

	}
}
