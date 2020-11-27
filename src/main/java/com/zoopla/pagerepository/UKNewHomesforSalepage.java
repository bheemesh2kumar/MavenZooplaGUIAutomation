package com.zoopla.pagerepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UKNewHomesforSalepage extends Homebasedpage {

	public WebDriver driver;

	public UKNewHomesforSalepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a[rel$='noreferrer noopener']")
	public WebElement advanceserachbutton;

	@FindBy(xpath = "//select[@id='radius']")
	public WebElement distancefromlocationdropdownele;

	@FindBy(xpath = "//select[@id='added']")
	public WebElement addeddropdownele;

	@FindBy(xpath = "//select[@id='sort_by']")
	public WebElement sortbydropdownele;

}
