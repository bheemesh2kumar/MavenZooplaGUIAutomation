package com.zoopla.utilities;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserutility {

	public ReadPropertyfile ReadPropertyfileref;
	public WebDriver driver;

	public WebDriver initializebrowser(String browser) throws FileNotFoundException {

		ReadPropertyfileref = new ReadPropertyfile();

		if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty(ReadPropertyfileref.getChromekey(), ReadPropertyfileref.getChromepath());

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox"))

		{
			System.setProperty(ReadPropertyfileref.getFirefoxkey(), ReadPropertyfileref.getFirefoxpath());
			driver = new FirefoxDriver();

		} else {

			System.out.println("Browser is not supported");

		}

		driver.get(ReadPropertyfileref.geturlname());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return driver;

	}

}
