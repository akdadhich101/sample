package com.assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup(){
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajay\\Desktop\\D Drive\\Ajay\\workspace\\selpro\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/
		System.out.println("it is beforetest anotation");
	}
	
	@BeforeClass
	public void bfclass(){
		System.out.println("it is before class anotation");
	}
	
	@AfterClass
	public void afclass(){
		System.out.println("it is after class anotation");
	}
	
	
	@Test(priority = 1)
	public void verifyTitleText(){
		/*String title = driver.getTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		System.out.println("Passed");*/
		System.out.println("Updating line in code form second Y person");
	}
	
	@Test(priority = 2)
	public void verifyLogo(){
		//String title = driver.getTitle();
		//driver.findElement(By.xpath("//img[@alt = 'Facebook']")).isDisplayed();
		System.out.println("logo matched");
		System.out.println("Adding new line in code form second Y person");
	}
	@AfterTest
	public void close() throws InterruptedException{
		/*driver.close();
		Thread.sleep(5000);*/
		System.out.println("it is aftertest anotation");
		System.out.println("ajay is adding new line 1");
	}

}

