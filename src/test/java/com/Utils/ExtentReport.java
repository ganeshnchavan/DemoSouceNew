package com.Utils;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	ExtentSparkReporter htmlreport;
	ExtentReports report;
	ExtentTest test;

	public void Configure() {
		String path = System.getProperty("user.dir") + "//ExtentReport//" + "Report.html";
		htmlreport = new ExtentSparkReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlreport);

		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("App", "Web");
		report.setSystemInfo("TesterName", "Ganesh");
		report.setSystemInfo("ReportType", "Sanity");

		htmlreport.config().setDocumentTitle("SanityReport");
		htmlreport.config().setReportName("ExtentReport");
		htmlreport.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext context) {
		// not implemented
		Configure();
		System.out.println("On Start method invoked....");
	}

	public void onFinish(ITestContext context) {
		// not implemented
		System.out.println("On Finished method invoked....");
		report.flush();
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:" + result.getName());
		test = report.createTest(result.getName());// create entry in html report
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));
		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";

		File screenShotFile = new File(screenShotPath);

		if (screenShotFile.exists()) {
			test.fail("Captured Screenshot:" + test.addScreenCaptureFromPath(screenShotPath));
			
		}
	}

	public void onTestStart(ITestResult result) {
		// not implemented
		System.out.println("Name of test method started:" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method sucessfully executed:" + result.getName());
		test = report.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
		// not implemented

	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
		System.out.println("Name of test  skipped method:" + result.getName());
		test = report.createTest("Test Case Succes :" + result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("skip Test" + result.getName(), ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

}
