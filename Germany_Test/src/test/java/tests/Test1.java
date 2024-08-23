package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testBase.BaseClass;

@Listeners(Utilities.extentReport.class)
public class Test1 extends BaseClass{

	@Test
	void valid_login_test() throws InterruptedException {
		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passElement= driver.findElement(By.xpath("//input[@id='password']"));
		WebElement submitElement=driver.findElement(By.xpath("//button[@type='submit']"));
		
		userName.sendKeys("xyz@gmail.com");
		passElement.sendKeys("Admin@123");
		submitElement.click();
		
		Thread.sleep(2000);
		WebElement cvElement = driver.findElement(By.xpath("//span[text()='CV analysis']"));  // Took the xpath to of CV analysis for using the assert statament
		Assert.assertNotNull(cvElement);  // Here we used the assert statement to verify whether the CV Analysis is present or not
		
	}
	
	
}
