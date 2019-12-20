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
    
//    @FindBy(how=How.XPATH , using="title")
//    WebElement title;
    
    @FindBy(how=How.ID  , using="first_name")
    WebElement firstName;
    
    @FindBy(how=How.ID  , using="surname")
    WebElement surname;
    @FindBy(how=How.ID  , using="phone")
    WebElement mobileNumber; 
    
    @FindBy(how=How.ID  , using="email")
    WebElement email;
    
    @FindBy(how=How.ID  , using="password")
    WebElement password;
    
    @FindBy(how=How.ID  , using="username")
    WebElement username;
    
    @FindBy(how=How.ID  , using="password")
    WebElement citizen;
    
    @FindBy(how=How.ID  , using="sa_id")
    WebElement rsaID;
    
    @FindBy(how=How.ID  , using="")
    WebElement product;
    
    @FindBy(how=How.ID  , using="")
    WebElement captcha;
    
     @FindBy(how=How.ID  , using="")
    WebElement submitButton;
    
    //
    public RegisterPageObjects (WebDriver driver ){
        this.driver = driver;
    }

    public void setTitle(String title ) {
        Select t = new Select(driver.findElement(By.xpath("//label[starts-with(@id,'select-options')]")));
        t.selectByVisibleText(title);
        
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
        Select s = new Select(driver.findElement(By.xpath("//label[starts-with(@id,'select-options')]")));
        s.selectByVisibleText(citizen);
       
    }  
    public void selectProduct() {
        this.product.click();
    }
    
    public void checkCaptcha() {
        this.captcha.click();
    }
    
    
    public void submitForm() {
        this.submitButton.click();
    }
    
}
