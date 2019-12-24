/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.co.tshimx.fnb.domain.Person;
import za.co.tshimx.fnb.pageobjects.HomePageObjects;
import za.co.tshimx.fnb.pageobjects.RegisterPageObjects;
import za.co.tshimx.fnb.utils.ExtentTestManager;
import za.co.tshimx.fnb.utils.HibernateDatabaseAccess;
import za.co.tshimx.fnb.utils.MobileNumberGenerator;

/**
 *
 * @author Tshimologo
 */
public class HomePageTest extends BaseTest {

    @Test
    public void createAccount() {
        try {
            logger.info("Starting the test :login  ");
            HomePageObjects homepage = PageFactory.initElements(driver, HomePageObjects.class);
            homepage.ClickOpenAccountLink();
            Thread.sleep(5000);
            String screenshotPath1 = BaseTest.getScreenshot(driver, "screenshot_");
            ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath1));

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Test(dependsOnMethods = {"createAccount"})
    public void register() {
        try {
            logger.info("Starting the test :register  ");
            RegisterPageObjects registerPage = PageFactory.initElements(driver, RegisterPageObjects.class);
            // database aceess
        HibernateDatabaseAccess dbAccess = new HibernateDatabaseAccess();
         Person person = dbAccess.getPersonDetails();

            registerPage.setTitle(person.getTitle()); 
            registerPage.setEmail(person.getEmail());
            registerPage.setMobileNumber(MobileNumberGenerator.getPhoneNumber());
            registerPage.setCitizen(person.getRsa_citizen());
////        registerPage.setTitle("DR");
////        registerPage.setEmail("maslwnyn@gmail.com");
////        registerPage.setMobileNumber(MobileNumberGenerator.getPhoneNumber());
////        registerPage.setCitizen("Yes");
            registerPage.setRsaID("6410015366");
            registerPage.setUsername(person.getUsername());            
////        registerPage.setUsername("tshimologo");
            Thread.sleep(3000);
            if (driver.findElement(By.xpath("//*[@ng-message='minlength']")).getText().equalsIgnoreCase("South African ID numbers are thirteen digits.")) {
                Assert.assertTrue(true, "Validation: South African ID numbers are thirteen digits - passed test");
                ExtentTestManager.getTest().log(LogStatus.PASS, "Validation: South African ID numbers are thirteen digits - passed test");
                takescreenshot();
            }
            registerPage.RsaIDClear();
            registerPage.setRsaID("1234567890123");
//          registerPage.setPassword("Tester1234*");
            registerPage.setPassword(person.getPassword());
            Thread.sleep(3000);
            if (driver.findElement(By.xpath("//*[@ng-message='aiValIdNumber']")).getText().equalsIgnoreCase("Number entered is not a valid SA ID number.")) {
                Assert.assertTrue(true, "Validation: Number entered is not a valid SA ID number. - passed test");
                ExtentTestManager.getTest().log(LogStatus.PASS, "Validation: Number entered is not a valid SA ID number. - passed test");
                takescreenshot();

            }
            
//          registerPage.setFirstName("Tshimologo");
//          registerPage.setSurname("Maselwanyane");
            registerPage.setFirstName(person.getFirstName());           
            registerPage.setSurname(person.getSurname());
            
          
            registerPage.RsaIDClear();
//          registerPage.setRsaID("8806014800082");
            registerPage.setRsaID(person.getIdNumber());
            String screenshotPath5 = BaseTest.getScreenshot(driver, "screenshot_");
            ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath5));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");

            takescreenshot();
            // Select Product
            String selected_product = "Derivatives Trader";
            if (selected_product.equalsIgnoreCase("Local Trading Account")) {
                registerPage.selectProduct1();
            } else if (selected_product.equalsIgnoreCase("Derivatives Trader")) {
                registerPage.selectProduct2();
            } else if (selected_product.equalsIgnoreCase("Global Trading Account (offshore)")) {
                registerPage.selectProduct3();
            } else if (selected_product.equalsIgnoreCase("All")) {
                registerPage.selectProduct4();
            }
            takescreenshot();
            // Click Captcha
            Thread.sleep(3000);
            registerPage.checkCaptcha();
            
            //  code to select captcha images
            Thread.sleep(3000);
            takescreenshot();
            registerPage.submitForm();
            Thread.sleep(3000);
            takescreenshot();
        } catch (Exception e) {
            logger.error(e.getMessage());
            ExtentTestManager.getTest().log(LogStatus.FAIL,e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
}
