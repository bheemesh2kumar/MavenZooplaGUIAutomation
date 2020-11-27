package com.zoopla.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZooplaLoginpage extends Homebasedpage {

	public WebDriver driver;

	public ZooplaLoginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='css-1mjljx5 eson0er0']/a//following-sibling::div/ul/li[4]/a")
	public WebElement Signfirstbutton;

	@FindBy(css = "input#signin_email")
	public WebElement loginusernameinputbox;

	@FindBy(css = "input#signin_password")
	public WebElement loginpwdinputbox;

	@FindBy(css = "button#signin_submit")
	public WebElement Signsecondbutton;

	@FindBy(xpath = "//div[@class='ui-cookie-consent-choose__buttons']//button[contains(text(),'Accept all cookies')]")
	public WebElement Acceptallcookiesbutton;

}
