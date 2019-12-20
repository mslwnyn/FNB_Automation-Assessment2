/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import za.co.tshimx.fnb.domain.Person;
import za.co.tshimx.fnb.pageobjects.HomePageObjects;
import za.co.tshimx.fnb.pageobjects.RegisterPageObjects;
import static za.co.tshimx.fnb.testcases.BaseTest.logger;
import za.co.tshimx.fnb.utils.ExtentTestManager;
import za.co.tshimx.fnb.utils.HibernateDatabaseAccess;
import za.co.tshimx.fnb.utils.MobileNumberGenerator;

/**
 *
 * @author Tshimologo
 */
public class RegisterTest  extends BaseTest{
    
     @Test
     public void register() {
        try {
            logger.info("Starting the test :register  ");
            RegisterPageObjects registerPage = PageFactory.initElements(driver, RegisterPageObjects.class);
            HibernateDatabaseAccess dbAccess = new HibernateDatabaseAccess();
            Person person = dbAccess.getPersonDetails();
            
            //registerPage.setTitle("");
            
            registerPage.setFirstName(person.getFirstName());
            registerPage.setSurname(person.getSurname());
            registerPage.setPassword(person.getPassword());
            registerPage.setRsaID(person.getEmail());
            registerPage.setEmail(person.getPassword());
            registerPage.setMobileNumber(MobileNumberGenerator.getPhoneNumber());
            registerPage.setRsaID(person.getIdNumber());
            registerPage.setMobileNumber(person.getMobileNumber());
            registerPage.setUsername(person.getUsername());
            registerPage.setCitizen(person.getRsa_citizen());
            // Select Product
            registerPage.selectProduct();
            // Click Captcha
            registerPage.checkCaptcha();
            Thread.sleep(20000);
            String screenshotPath1 = BaseTest.getScreenshot(driver, "screenshot_");
            ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath1));
            registerPage.submitForm();
            Thread.sleep(20000);
            String screenshotPath2 = BaseTest.getScreenshot(driver, "screenshot_");
            ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath2));
           
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
     }
}
