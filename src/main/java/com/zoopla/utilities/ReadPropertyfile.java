package com.zoopla.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyfile

{

	Properties prop;

	public ReadPropertyfile() throws FileNotFoundException {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "\\Configurations\\config.properties"));

			prop.load(fis);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		catch (IOException iox) {
			iox.printStackTrace();
		}

	}

	public String geturlname() {
		return prop.getProperty("url.name");
	}

	public String getusername() {
		return prop.getProperty("username");
	}

	public String getpwd() {
		return prop.getProperty("pwd");
	}

	public String getChromekey() {
		return prop.getProperty("Chrome.key");
	}

	public String getChromepath() {
		return prop.getProperty("Chrome.path");
	}

	public String getFirefoxkey() {
		return prop.getProperty("Firefox.key");
	}

	public String getFirefoxpath() {
		return prop.getProperty("Firefox.path");
	}

	public String getbrowser() {
		return prop.getProperty("browser");
	}

}
