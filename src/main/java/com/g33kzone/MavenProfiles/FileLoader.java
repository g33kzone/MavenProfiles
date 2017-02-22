package com.g33kzone.MavenProfiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class FileLoader {

	InputStream inputStream;

	public void fetchProperty() {

		try {
			Properties prop = new Properties();
			String propFileName = "env.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			// get the property value and print it out
			String env_value = prop.getProperty("environment");

			System.out.println("Environment - " + env_value);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

	}
}
