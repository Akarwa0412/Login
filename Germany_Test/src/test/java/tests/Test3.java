package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testBase.BaseClass;

@Listeners(Utilities.extentReport.class)
public class Test3 extends BaseClass {

	@Test
	void empty_login() {
		
		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passElement= driver.findElement(By.xpath("//input[@id='password']"));
		WebElement submitElement=driver.findElement(By.xpath("//button[@type='submit']"));
		
		userName.sendKeys("");
		passElement.sendKeys("");
		submitElement.click();
		
		WebElement alertElement=driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		Assert.assertNotNull(alertElement);  // To check whether the warning message is present or not  
		System.out.println(alertElement.getText());   // For printing the alert statement on the console window
		
		
	}
}
