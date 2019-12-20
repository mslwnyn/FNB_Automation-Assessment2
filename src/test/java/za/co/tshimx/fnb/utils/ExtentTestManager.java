/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tshimologo
 */
public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    private static ExtentReports extent = ExtentManager.getInstance();
    
    
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest extentTest = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), extentTest);

        return extentTest;
    }
    
    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        extent.endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    
}
