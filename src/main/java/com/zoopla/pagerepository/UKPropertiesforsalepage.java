package com.zoopla.pagerepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UKPropertiesforsalepage extends Homebasedpage {

	public WebDriver driver;

	public UKPropertiesforsalepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@id='ui-id-1']//li/descendant::a")
	public List<WebElement> ukpropertysalesuggestions;

	@FindBy(css = "button[id$='submit']")
	public WebElement ukpropertysalesearchbutton;

	@FindBy(css = "input[id^='search-input-location']")
	public WebElement ukpropertysaleinputbox;

	@FindBy(css = "select[id='forsale_price_min']")
	public WebElement ukpropertysaleminpricedropdown;

	@FindBy(css = "select[id='forsale_price_max']")
	public WebElement ukpropertysalemaxpricedropdown;

}
