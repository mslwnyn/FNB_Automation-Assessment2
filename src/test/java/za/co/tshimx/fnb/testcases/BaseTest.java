/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.testcases;

import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import za.co.tshimx.fnb.utils.ExtentTestManager;


/**
 *
 * @author Tshimologo
 */
public class BaseTest {

    final static Logger logger = Logger.getLogger(BaseTest.class);
    static WebDriver driver;
    WebDriverWait wait;
    Properties env_prop;
    WebElement html;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        logger.info("Before Suite : loading properties ");
        loadProperties();
    }

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) throws Exception {
        logger.info("setupTest :  " + browser);
        if (browser.equalsIgnoreCase("firefox")) {
            try {
                System.setProperty(env_prop.getProperty("firefox.webdriver.key"), env_prop.getProperty("firefox.webdriver.value"));
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                //html = driver.findElement(By.tagName("html"));
                //html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
                driver.get(env_prop.getProperty("web.url"));
               // String screenshotPath = BaseTest.getScreenshot(driver, "screenshot_");
               // ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath));
            } catch (Exception e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(env_prop.getProperty("chrome.webdriver.key"), env_prop.getProperty("chrome.webdriver.value"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            html = driver.findElement(By.tagName("html"));
            html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
            driver.get(env_prop.getProperty("web.url"));
            wait = new WebDriverWait(driver, 40);
            Thread.sleep(5000);
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty(env_prop.getProperty("ie.webdriver.key"), env_prop.getProperty("ie.webdriver.value"));
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.get(env_prop.getProperty("web.url"));
            wait = new WebDriverWait(driver, 40);
            Thread.sleep(25000);
        }else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty(env_prop.getProperty("edge.webdriver.key"), env_prop.getProperty("edge.webdriver.value"));
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get(env_prop.getProperty("web.url"));
            wait = new WebDriverWait(driver, 40);
            Thread.sleep(5000);
        }

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        logger.info("closeBrowser :  ");
        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
      //  driver.quit();
    }

    public void loadProperties() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("environment.properties");
        env_prop = new Properties();
        env_prop.load(inputStream);
        inputStream.close();
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
    
    
    public static void takescreenshot() throws Exception{
        
        String screenshotPath6 = BaseTest.getScreenshot(driver, "screenshot_");
        ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().addScreenCapture(screenshotPath6));
             
             
    }

}
