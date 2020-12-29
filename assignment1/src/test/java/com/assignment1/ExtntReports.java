package com.assignment1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtntReports {
	
	public ExtentReports extent;
	ExtentTest test;
	 String path = System.getProperty("user.dir") + "\\Reprots\\extnt.html";
	@BeforeTest
	public void config(){
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Sample Project Automation");
		reporter.config().setDocumentTitle("Sample");
		
		 extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ajay Kumar Dadhich");
		
	}
	
	@Test
	public void verifyExtent(){
		
		 test = extent.createTest("Verify Extent Reports scenario");
		test.pass("Its passed step");
		System.out.println("its first testcase");
		extent.flush();
	}
	

}
