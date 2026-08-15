package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static Properties prop = new Properties();
	private static String path = "config/config.properties";
	private static String env;

	static {

		env = System.getProperty("env");

		switch (env.toLowerCase()) {
		case "dev" -> path = "config/config.dev.properties"; // Added config.

		case "qa" -> path = "config/config.qa.properties"; // Added config.

		case "uat" -> path = "config/config.uat.properties"; // Added config.

		default -> path = "config/config.qa.properties"; // Added config.

		}

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		if (input == null) {
			throw new RuntimeException("Cannot find the file at the path" + path);
		}

		try {

			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(prop.getProperty("BASE_URI"));

	}

	public static String getProperty(String key) throws IOException {

		return prop.getProperty(key);

	}
}
