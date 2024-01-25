package com.simplilearn.selenium_scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPage {
	
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void setUp() {
		String url = "http://localhost:9010/register";
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test(description="Test for Registration Page")
	public void testRegistrationpage() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("Aadvik");
		driver.findElement(By.id("email")).sendKeys("aadvik24@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Aadvik@2425");
		driver.findElement(By.xpath("/html/body/div[2]/form/button")).submit();
		
		String expectedTitle  = "";
		String actualTitle  = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}
		
		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
		
		
	}

}
