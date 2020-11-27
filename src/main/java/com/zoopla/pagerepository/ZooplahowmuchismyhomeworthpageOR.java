package com.zoopla.pagerepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZooplahowmuchismyhomeworthpageOR extends Homebasedpage {

	public WebDriver driver;

	public ZooplahowmuchismyhomeworthpageOR(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='css-nqyyb3 e4o3ca53']/a[4]")
	public WebElement housepriceshyperlink;

	@FindBy(xpath = "//table[@class='browse-table']/tbody")
	public WebElement Browsehousepricestable;

	public void getregiondetails(WebElement tableelement, int val) {

		List<WebElement> tablerowlist = tableelement.findElements(By.xpath("./tr/td[4]/button"));

		for (WebElement ele : tablerowlist) {
			System.out.println(ele.getText());

			if (Integer.parseInt(ele.getText().substring(1).trim()) >= val) {
				String reagiontext = tableelement.findElement(By.xpath("./tr/td[1]/button")).getText();

				System.out.println(ele.getText() + " " + reagiontext);
			}

		}

	}

}
