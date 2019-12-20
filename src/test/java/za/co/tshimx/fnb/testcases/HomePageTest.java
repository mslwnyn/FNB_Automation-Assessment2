/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import za.co.tshimx.fnb.pageobjects.HomePageObjects;
import za.co.tshimx.fnb.utils.ExtentTestManager;

/**
 *
 * @author Tshimologo
 */
public class HomePageTest extends BaseTest{
    
    
     @Test
     public void createAccount() {
        try {
            logger.info("Starting the test :login  ");
            HomePageObjects homepage = PageFactory.initElements(driver, HomePageObjects.class);
            homepage.ClickOpenAccountLink();
            Thread.sleep(20000);
            String screenshotPath1 = BaseTest.getScreenshot(driver, "screenshot_");
            ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath1));
            
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        
    }
}
