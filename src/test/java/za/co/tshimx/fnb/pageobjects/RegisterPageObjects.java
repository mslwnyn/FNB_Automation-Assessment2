/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import za.co.tshimx.fnb.testcases.BaseTest;

/**
 *
 * @author Tshimologo
 */
public class RegisterPageObjects extends BaseTest{
    WebDriver driver;
    
    
    @FindBy(how=How.XPATH , using="//*[@class='select-dropdown' and @value='MR']")        
    WebElement titleElement;
    
    @FindBy(how=How.XPATH  , using="//*[@id='first_name']")
    WebElement firstName;
    
    @FindBy(how=How.XPATH  , using="//*[@id='surname']")
    WebElement surname;
    @FindBy(how=How.XPATH  , using="//*[@id='phone']")
    WebElement mobileNumber; 
    
    @FindBy(how=How.XPATH  , using="//*[@id='email']")
    WebElement email;
    
    @FindBy(how=How.XPATH  , using="//*[@id='password']")
    WebElement password;
    
    @FindBy(how=How.XPATH  , using="//*[@id='username']")
    WebElement username;
    
    @FindBy(how=How.XPATH  , using="//*[@class='select-dropdown' and @value='Yes']")
    WebElement citizenElement;
    
    @FindBy(how=How.XPATH  , using="//*[@id='sa_id']")
    WebElement rsaID;
    
    
    @FindBy(how=How.XPATH  , using="//input[@id='local-trading']")  
    WebElement product1;
    
           
    @FindBy(how=How.XPATH  , using="//input[@id='cfd-trading']")
    WebElement product2;

    
    @FindBy(how=How.XPATH  , using="//input[@id='offshore-trading']")
    WebElement product3;
    
    
   @FindBy(how=How.XPATH  , using="//input[@id='both-product']")
   WebElement product4;
    
   
    @FindBy(how=How.XPATH  , using="//*[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']")
    WebElement captcha;
    
     @FindBy(how=How.XPATH  , using="//*[@class='waves-effect waves-light btn']")
     WebElement submitButton;
    
    //
    public RegisterPageObjects (WebDriver driver ){
        this.driver = driver;
    }

    public void setTitle(String title ) {
        titleElement.click();
        driver.findElement(By.xpath("//span[text()='"+title+"']")).click();
       
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setSurname(String firstName) {
        this.surname.sendKeys(firstName);
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber.sendKeys(mobileNumber);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setRsaID(String rsaID) {
        this.rsaID.sendKeys(rsaID);
    }
    
    public void setUsername(String userName) {
        this.username.sendKeys(userName);
    }

    public void setCitizen(String citizen) {
        citizenElement.click();
        driver.findElement(By.xpath("//span[text()='"+citizen+"']")).click();
       
    }  
    public void RsaIDClear() {
        this.rsaID.clear();
    }
    public void selectProduct1() {
        this.product1.click();
    }
    
    public void selectProduct2() {
        this.product2.click();
    }
    
    public void selectProduct3() {
        this.product3.click();
    }
    
    public void selectProduct4() {
        this.product4.click();
    }
       
    
    public void checkCaptcha() {
        this.captcha.click();
    }
 
    public void submitForm() {
        this.submitButton.click();
    }
    
}
