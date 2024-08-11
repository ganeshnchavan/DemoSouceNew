package com.PageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoad {
WebDriver driver;


public DashBoad(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "(//div[@class='app_logo'])[1]")
WebElement Logo;

public String VerifyLogo() {
	return Logo.getText();
}
}
