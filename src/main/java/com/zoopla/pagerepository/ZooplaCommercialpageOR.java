package com.zoopla.pagerepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZooplaCommercialpageOR extends Homebasedpage {

	public WebDriver driver;

	public ZooplaCommercialpageOR(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h2[contains(text(),'Browse properties to let  by area *')]")
	public WebElement Browsepropertiestoletbyarea;

	@FindBy(xpath = "//div[@id='landing-page']//h2[contains(text(),'Browse commercial agents  by area')]")
	public WebElement Browsecommercialagentsbyarealabel;

	@FindBy(xpath = "//table[@class='browse-table']")
	public WebElement Browsepropertieswebtable;

	@FindBy(xpath = "//table[@class='browse-table']/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/a")
	public WebElement londonfirstelement;

	@FindBy(xpath = "//div[@class='split2l']//ul[@class='bottom']/li[1]/a")
	public WebElement londonareasfirstelement;

	@FindBy(xpath = "//select[@name='page_size']")
	public WebElement pagenumbersdropdowncommerialagents;

	@FindBy(xpath = "//select[@name='agents_sort']")
	public WebElement hightolowestdropdowncommerialagents;

	// web table itrearation based on charcter value

	public void getavgaskingrentvalues(WebElement ele, char ch) {

		List<WebElement> tablerows = ele.findElements(By.xpath(".//tr"));

		for (int i = 0; i < tablerows.size(); i++) {

			if (i == 0) {
				continue;
			}

			if (tablerows.get(i).findElement(By.xpath(".//td[1]/a")).getText().charAt(0) == ch) {
				String avgrentval = tablerows.get(i).findElement(By.xpath(".//td[3]/a")).getText();

				System.out.println(tablerows.get(i).findElement(By.xpath(".//td[1]/a")).getText() + " " + avgrentval);
			}
		}

	}

	// selectcolumn value based on another column value
	public void clicktablecellvaluebasedinput(WebElement table, String inputcalval) {

		List<WebElement> tablerows = table.findElements(By.xpath("./tbody/tr[starts-with(@class,'browse-row')]"));

		int size = tablerows.size();

		System.out.println("toatol rows" + size);

		for (int i = 0; i < size; i++) {

			// WebElement xpath = tablerows.get(i).findElement(By.xpath("./td[2]/button"));

			String actval = tablerows.get(i).findElement(By.xpath("./td[2]/button")).getText().trim();

			String expval = inputcalval.trim();

			if (tablerows.get(i).findElement(By.xpath("./td[2]/button")).getText().trim()
					.equalsIgnoreCase(inputcalval.trim())) {
				tablerows.get(i).findElement(By.xpath("./td[3]/button")).click();

				break;
			}

		}

	}

}
