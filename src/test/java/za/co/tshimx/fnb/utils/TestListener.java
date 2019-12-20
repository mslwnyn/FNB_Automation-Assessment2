/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.utils;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author Tshimologo
 */
public class TestListener implements ITestListener {

    @Override
    public synchronized void onStart(ITestContext context) {

       // logger.info("***  TestListener : Test Suite " + context.getName());

    }


    @Override
    public synchronized void onTestStart(ITestResult result) {

        ExtentTestManager.startTest( result.getMethod().getMethodName() );
        ExtentTestManager.getTest().log(LogStatus.INFO, "TestListener - Running test method: " + result.getMethod().getMethodName());

    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().log(LogStatus.PASS, "TestListener :     " + result.getMethod().getMethodName() + ": Test Completed Successfully.");
        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {

     
        ExtentTestManager.getTest().log(LogStatus.FAIL, " Test has failed ");
        ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();
        

    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {

       // logger.info("*** TestListener : Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(LogStatus.INFO, Thread.currentThread().getName()+": "  + result.getMethod().getMethodName() + " : is Skipped.");
        ExtentTestManager.getTest().log(LogStatus.SKIP, result.getThrowable());
        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();

    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       
        ExtentTestManager.getTest().log(LogStatus.PASS, result.getMethod().getMethodName() + ": Test within  success percentage.");
        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();
     
    }
    
    
    @Override
    public  synchronized  void onFinish(ITestContext context) {

       // logger.info("*** TestListener : Test Suite " + context.getName().toString() + " ended ***");
        //ExtentTestManager.getTest().log(LogStatus.INFO,  context.getName() + " : OnFinish executed on Machine: " + context.getHost());
        ExtentManager.getInstance().flush();
        
    }

}