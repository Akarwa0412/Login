package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	
	
	@BeforeClass
	public void initializeTest() throws InterruptedException {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.germanyiscalling.com");
		
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void breakdown() {
		driver.quit();
	}
	
}
