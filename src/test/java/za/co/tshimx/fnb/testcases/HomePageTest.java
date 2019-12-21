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
//        HibernateDatabaseAccess dbAccess = new HibernateDatabaseAccess();
//          Person person = dbAccess.getPersonDetails();

//         registerPage.setTitle(person.getTitle()); 
//         registerPage.setFirstName(person.getFirstName());
//         registerPage.setSurname(person.getSurname());
//         registerPage.setEmail(person.getEmail());
//         registerPage.setMobileNumber(MobileNumberGenerator.getPhoneNumber());
//         registerPage.setUsername(person.getUsername());
//         registerPage.setPassword(person.getPassword());
//         registerPage.setCitizen(person.getRsa_citizen());
            registerPage.setTitle("DR");
            registerPage.setEmail("maslwnyn@gmail.com");
            registerPage.setMobileNumber(MobileNumberGenerator.getPhoneNumber());
            registerPage.setCitizen("Yes");
            registerPage.setRsaID("6410015366");
            registerPage.setUsername("tshimologo");
            Thread.sleep(3000);
            if (driver.findElement(By.xpath("//*[@ng-message='minlength']")).getText().equalsIgnoreCase("South African ID numbers are thirteen digits.")) {
                Assert.assertTrue(true, "Validation: South African ID numbers are thirteen digits - passed test");
                ExtentTestManager.getTest().log(LogStatus.PASS, "Validation: South African ID numbers are thirteen digits - passed test");
                String screenshotPath3 = BaseTest.getScreenshot(driver, "screenshot_");
                ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath3));
            }
            registerPage.RsaIDClear();
            registerPage.setRsaID("1234567890123");
            registerPage.setPassword("Tester1234*");
            Thread.sleep(3000);
            if (driver.findElement(By.xpath("//*[@ng-message='aiValIdNumber']")).getText().equalsIgnoreCase("Number entered is not a valid SA ID number.")) {
                Assert.assertTrue(true, "Validation: Number entered is not a valid SA ID number. - passed test");
                ExtentTestManager.getTest().log(LogStatus.PASS, "Validation: Number entered is not a valid SA ID number. - passed test");
                String screenshotPath4 = BaseTest.getScreenshot(driver, "screenshot_");
                ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath4));

            }

            registerPage.setFirstName("Tshimologo");
            registerPage.setSurname("Maselwanyane");
//          registerPage.setRsaID(person.getIdNumber());
            registerPage.RsaIDClear();
            registerPage.setRsaID("8806014800082");

            String screenshotPath5 = BaseTest.getScreenshot(driver, "screenshot_");
            ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath5));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");

            takescreenshot();
            // Select Product
            String selected_product = "Local Trading Account";
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
            registerPage.checkCaptcha();
            
            //  code to select captcha images
            Thread.sleep(3000);
            takescreenshot();
            registerPage.submitForm();
            Thread.sleep(20000);
            takescreenshot();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
