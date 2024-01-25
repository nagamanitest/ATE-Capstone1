package com.simplilearn.selenium_scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductsToCartPage {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		String url = "http://localhost:9010/";
		String driverpath = "drivers\\Window\\chromedriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverpath);

		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();

		// step4: add explicit wait (Conditional Delay)
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		// step5: launch browser
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(description="To test Add to cart Page",priority=1)
	public void testloginpage() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("aadvik24@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Aadvik@2425");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/form/button")).submit();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mynavbar\"]/ul/li[1]/a")).click();

		
	}
	
	

}
