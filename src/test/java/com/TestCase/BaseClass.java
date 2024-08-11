package com.TestCase;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Logger log;
	ReadConfig Read = new ReadConfig();
	String URL = Read.GetUrl();
	String Uname = Read.GetUname();
	String Password = Read.GetPassword();

	@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log = LogManager.getLogger("SwagLabs");

		driver.get(URL);
		log.info("Browser Open");
		driver.findElement(By.id("user-name")).sendKeys(Uname);
		log.info("Username");
		driver.findElement(By.id("password")).sendKeys(Password);
		log.info("Password");
		driver.findElement(By.id("login-button")).click();
		log.info("Click on Submit");

	}
	@AfterTest
	public void TearDown()
	{
		log.info("Browser Close.............");
		driver.close();
	}
	public void CaptureScreenshot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir") + "//Screenshot//" + testName + ".png");
		FileUtils.copyFile(src, dest);
				
	}

}
