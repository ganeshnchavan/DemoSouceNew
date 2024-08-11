package com.PageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractComp
{
	WebDriver driver;
	public AbstractComp(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
   public void goToCart()
   {
	   driver.findElement(By.cssSelector("span[class*='cart_badge']")).click();
	   
   }
}
