package com.TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjectClass.AbstractComp;
import com.PageObjectClass.AddProduct;
import com.PageObjectClass.DashBoad;

public class MyTestCases extends BaseClass {

	@Test(priority = 1)
	public void VerifyLogo() throws IOException {
		DashBoad d = new DashBoad(driver);
		String Actual = d.VerifyLogo();
		String Expected = "Swag Labs";
		if (Actual.equals(Expected)) {
			Assert.assertTrue(true);
			log.info("Logo match");
		} else {
			log.info("Logo  not match");
			CaptureScreenshot(driver, "Capture Screenshot");
			Assert.assertTrue(false);

		}
	}
	
	@Test(priority = 2)
	public void AddProducttoart() throws IOException
	{
		AddProduct ad=new AddProduct(driver);
		
		ad.AddtoCart1();
		log.info(" add product cart");
		//Assert.assertEquals(true, null);
		AbstractComp abs=new AbstractComp(driver);
		abs.goToCart();
		WebElement addedItem=driver.findElement(By.cssSelector(".cart_item a div"));
		//Assert.assertEquals(addedItem.getText(),"Sauce Labs Backpack.");
		if (addedItem.getText().equals("Sauce Labs Backpack")) {
			Assert.assertTrue(true);
			log.info(" match");
		} else {
			log.info("  not match");
			CaptureScreenshot(driver, "Capture Screenshot");
			Assert.assertTrue(false);
		}
	}
}
