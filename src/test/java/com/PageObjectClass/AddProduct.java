package com.PageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
	
		WebDriver driver;


		public AddProduct(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
		WebElement ClickOnaddProduct;

		 
		public void AddtoCart1() {
			ClickOnaddProduct.click();
		}
		}

