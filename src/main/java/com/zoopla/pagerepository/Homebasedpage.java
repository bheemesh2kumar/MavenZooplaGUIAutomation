package com.zoopla.pagerepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.natives.SysUtil;

public class Homebasedpage {

	// loginto page

	public void logintozoopla(WebElement firstlloginbutton, WebElement usernameinputbox, String usernameval,
			WebElement pwdinputbox, String pwdval, WebElement secondsignbutton) {

		firstlloginbutton.click();
		usernameinputbox.sendKeys(usernameval);
		pwdinputbox.sendKeys(pwdval);
		secondsignbutton.click();

	}

	public void mouseoverele(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();
	}

	public void selectdropdownval(WebElement dropdownelement, String value) {
		new Select(dropdownelement).selectByVisibleText(value);

	}

	public void selectvaluefromsuggestons(List<WebElement> valuesuggestions, String str) {
		for (WebElement ele : valuesuggestions) {
			System.out.println(ele.getText());

			if (ele.getText().equalsIgnoreCase(str)) {
				ele.click();
			}

		}

	}

	public void scrollintoview(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)", ele);

	}

	public void waitforelemnt(WebDriver driver, int timeout, WebElement ele)

	{

		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOf(ele));

	}

	public List<WebElement> getdropdownelements(WebElement ele) {
		Select seleelts = new Select(ele);
		return seleelts.getOptions();
	}

	public boolean isdropdownvaluessorted(List<WebElement> listactdropvalues) {

		boolean flag = false;

		ArrayList<String> actvalues = new ArrayList<String>();

		for (WebElement ele : listactdropvalues) {
			actvalues.add(ele.getText());
		}

		ArrayList<String> epvalues = new ArrayList<String>();

		epvalues.addAll(actvalues);

		Collections.sort(epvalues);

		for (String str : actvalues) {
			System.out.println("actual are " + str);
		}

		for (String str : epvalues) {
			System.out.println("exp values are " + str);
		}

		if (actvalues.equals(epvalues)) {
			flag = true;
		}

		return flag;

	}

}
