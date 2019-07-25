package com.maveric.restapi;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListennersExample implements ITestListener {


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start"+result.getTestName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success "+result.getTestName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure "+result.getTestName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped"+result.getTestName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On Success Perecentage"+result.getTestName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart"+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish"+context.getName());
		
	}


}
