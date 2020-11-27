package com.zoopla.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zooplahomepage extends Homebasedpage {

	public WebDriver driver;

	public Zooplahomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='css-12w7sj6 evwl3xc3']/child::li/div/a[contains(text(),'For sale')]")
	public WebElement forsalehyperlik;

	@FindBy(xpath = "//ul[@class='css-1hvx20j ex9l90o1']/li[1]/a[contains(text(),'UK property for sale')]")
	public WebElement UkProeprtiesforsaledropdown;

	@FindBy(xpath = "//ul[@class='css-1hvx20j ex9l90o1']/li[2]/a[contains(text(),'UK new homes for sale')]")
	public WebElement Uknewhomeforsaledropdown;

	@FindBy(xpath = "//ul[@class='css-12w7sj6 evwl3xc3']//li[@data-testid='header-primarynav-mn-commercial']")
	public WebElement Commercialmenu;

	@FindBy(xpath = "//ul[@class='css-12w7sj6 evwl3xc3']//li[@data-testid='header-primarynav-mn-commercial']//ul/li[1]")
	public WebElement UKCommercialpropertytolet;

	@FindBy(xpath = "//ul[@class='css-12w7sj6 evwl3xc3']//li[@data-testid='header-primarynav-mn-commercial']//ul/li[3]")
	public WebElement UKCommercialagentsdropdown;

	@FindBy(xpath = "//li[@data-testid='header-primarynav-mn-prices']/div[2]/ul/li[4]/a")
	public WebElement howmuchismyhomeworthdropdownele;

	@FindBy(xpath = "//li[@data-testid='header-primarynav-mn-prices']/div[1]/a")
	public WebElement housepricesheadermenu;

}
