package com.ndosi.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {

    WebDriver driver;

    @FindBy(id = "nav-btn-practice")
    WebElement btnLearningMaterial;

    @FindBy(id = "signup-toggle")
    WebElement btnSignUpHere;

    @FindBy(id = "register-firstName")
    WebElement txtFirstname;

    @FindBy(id = "register-lastName")
    WebElement txtLastname;

    @FindBy(id = "register-email")
    WebElement txtEmail;

    @FindBy(id = "register-password")
    WebElement txtPassword;

    @FindBy(id = "register-confirmPassword")
    WebElement txtConfirmPassword;

    @FindBy(id = "register-submit")
    WebElement btnCreateAccount;

    Logger logger = LogManager.getLogger(new Object(){}.getClass().getName());
    
    public Registration(WebDriver driver){
        this.driver = driver;        
        PageFactory.initElements(driver, this);
    }

    public String createAccount(String firstname, String lastname, String email, String password, String confirmPassword){
        String alertResponse = null;
        Alert alert = driver.switchTo().alert();
        try {
            btnLearningMaterial.click();
            btnSignUpHere.click();
            txtFirstname.sendKeys(firstname);
            txtLastname.sendKeys(lastname);
            txtEmail.sendKeys(email);
            txtPassword.sendKeys(password);
            txtConfirmPassword.sendKeys(confirmPassword);
            btnCreateAccount.click();
            alertResponse = alert.getText();
            alert.accept();
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
            e.printStackTrace();
        }
        System.out.println("ALERT RESPONSE: " + alertResponse);
        return alertResponse;
    }

}
