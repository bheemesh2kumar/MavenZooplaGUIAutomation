package com.zoopla.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Commanutilities {

	public String takescreenshot(WebDriver driver, String screenshotname) throws IOException {

		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;

		File soursefile = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "//ScreenShots//" + screenshotname + datename + ".png";

		File finaldstination = new File(destination);

		FileUtils.copyFile(soursefile, finaldstination);

		return destination;

	}

}
