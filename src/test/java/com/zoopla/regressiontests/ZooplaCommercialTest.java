package com.zoopla.regressiontests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZooplaCommercialTest extends BaseTest {

	@Test
	public void Commercialpropertyvalidation() {

		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.Commercialmenu);
		Zooplahomepageref.UKCommercialpropertytolet.click();

		ZooplaCommercialpageORref.scrollintoview(driver, ZooplaCommercialpageORref.Browsepropertiestoletbyarea);

		ZooplaCommercialpageORref.getavgaskingrentvalues(ZooplaCommercialpageORref.Browsepropertieswebtable, 'N');

	}

	@Test
	public void UKCommercialagents() throws InterruptedException {

		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.Commercialmenu);
		Zooplahomepageref.UKCommercialagentsdropdown.click();

		ZooplaCommercialpageORref.scrollintoview(driver, ZooplaCommercialpageORref.Browsecommercialagentsbyarealabel);

		ZooplaCommercialpageORref.clicktablecellvaluebasedinput(ZooplaCommercialpageORref.Browsepropertieswebtable,
				"London");

		Thread.sleep(5000);

	}

	@Test
	public void commercialagentssortingorder() {

		Zooplahomepageref.mouseoverele(driver, Zooplahomepageref.Commercialmenu);
		Zooplahomepageref.UKCommercialagentsdropdown.click();

		ZooplaCommercialpageORref.scrollintoview(driver, ZooplaCommercialpageORref.Browsecommercialagentsbyarealabel);

		ZooplaCommercialpageORref.clicktablecellvaluebasedinput(ZooplaCommercialpageORref.Browsepropertieswebtable,
				"London");

		ZooplaCommercialpageORref.waitforelemnt(driver, 20, ZooplaCommercialpageORref.londonfirstelement);
		ZooplaCommercialpageORref.londonfirstelement.click();

		ZooplaCommercialpageORref.waitforelemnt(driver, 20, ZooplaCommercialpageORref.londonareasfirstelement);

		ZooplaCommercialpageORref.londonareasfirstelement.click();

		//ZooplaCommercialpageORref.waitforelemnt(driver, 20,
				//ZooplaCommercialpageORref.hightolowestdropdowncommerialagents);

		boolean flag = ZooplaCommercialpageORref.isdropdownvaluessorted(ZooplaCommercialpageORref
				.getdropdownelements(ZooplaCommercialpageORref.hightolowestdropdowncommerialagents));

		if (flag == true) {
			List<WebElement> dropvalue = ZooplaCommercialpageORref
					.getdropdownelements(ZooplaCommercialpageORref.hightolowestdropdowncommerialagents);

			for (WebElement ele : dropvalue) {
				System.out.println(ele.getText() + " " + " " + " sorted successfully");
			}

		}

	}

}
