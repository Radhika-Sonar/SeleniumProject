package com.qa.Tests;


import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAutomation 
{
	
	static WebDriver driver = null;
	
	@BeforeTest()
	public void setup()
	{
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://www.naukri.com/");
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@Test()
	public void LoginAndupdateResume()
	{
		System.out.println("user.dir");
		
		 driver.findElement(By.id("login_Layer")).click();
		   
		   By username = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
		   By password = By.xpath("//input[@placeholder='Enter your password']");
		   
		   driver.findElement(username).clear();
		   driver.findElement(username).sendKeys("sonarradhika1@gmail.com");
		   driver.findElement(password).clear();
		   driver.findElement(password).sendKeys("Radhika@21");
		   
		   driver.findElement(By.xpath("//button[text()='Login']")).click();
		   driver.findElement(By.linkText("View profile")).click();
		   
		   File file = new File("src/main/resources/Files/RadhikaSonar_DataAnalyst.pdf");
		   driver.findElement(By.id("attachCV")).sendKeys(file.getAbsolutePath());
		   
		   
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Success']")));
		   
		   String msg = driver.findElement(By.xpath("//p[text()='Success']")).getText();
		   if(msg.equals("Success"))
		   {
			   System.out.println("Resume Uploaded successfully");
		   }
		   else
		   {
			   System.out.println("Resume not Uploaded successfully");
		   }
	}
	
	@AfterTest()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		   driver.quit();
	}

}
