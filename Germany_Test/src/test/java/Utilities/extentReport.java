package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;
 
 
public class extentReport implements ITestListener {
	public ExtentSparkReporter sparkReporter; //UI of report
	public ExtentReports extent;  // It will populate the common info on the report
	public ExtentTest test;   // creating test case entries in report and updating the test method status
 
	String repName;
 
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
 
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
 
		sparkReporter.config().setDocumentTitle(" Automation Report"); // Title of report
		sparkReporter.config().setReportName("Login Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
 
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter); //attach with report
		extent.setSystemInfo("Application", "login");
		extent.setSystemInfo("Module","Home Page");
		extent.setSystemInfo("Environment", "QAE");
	}
 
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
		
	}
 
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());

	}
 
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
 
	public void onFinish(ITestContext testContext) {
		extent.flush();   // Generates extent report
 
		
	}
 
}