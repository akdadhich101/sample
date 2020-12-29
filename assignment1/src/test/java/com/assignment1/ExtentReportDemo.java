package com.assignment1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent;
	
@BeforeTest
public void config()
{
// ExtentReports , ExtentSparkReporter
String path =System.getProperty("user.dir")+"\\reports\\index.html";
ExtentSparkReporter reporter = new ExtentSparkReporter(path);
reporter.config().setReportName("Web Automation Results");
reporter.config().setDocumentTitle("Test Results");
extent =new ExtentReports();
extent.attachReporter(reporter);
extent.setSystemInfo("Tester", "Rahul Shetty");
}

@Test
public void initialDemo()

{
ExtentTest test= extent.createTest("Initial Demo");
extent.flush();

}
}
