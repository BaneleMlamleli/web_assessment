package com.ndosi.pages;

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

    
    public Registration(WebDriver driver){
        this.driver = driver;        
        PageFactory.initElements(driver, this);
    }

    public void goToRegistration(){
        btnLearningMaterial.click();
        btnSignUpHere.click();
    }

    public String createAccount(String firstname, String lastname, String email, String password, String confirmPassword){
        String alertResponse = null;
        try {
            goToRegistration();
            txtFirstname.sendKeys(firstname);
            txtLastname.sendKeys(lastname);
            txtEmail.sendKeys(email);
            txtPassword.sendKeys(password);
            txtConfirmPassword.sendKeys(confirmPassword);
            btnCreateAccount.click();
            alertResponse = driver.switchTo().alert().getText();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return alertResponse;
    }

}
