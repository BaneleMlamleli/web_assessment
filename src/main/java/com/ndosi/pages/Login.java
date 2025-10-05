package com.ndosi.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    @FindBy(id = "nav-btn-practice")
    WebElement btnLearningMaterial;

    @FindBy(id = "login-email")
    WebElement txtEmail;

    @FindBy(id = "login-password")
    WebElement txtPassword;

    @FindBy(id = "login-submit")
    WebElement btnLogin;

    @FindBy(id = "practice-heading")
    WebElement successfulLoginMessage;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String validCredentials(String email, String password){
        String loginMessage = null;
        try {
            btnLearningMaterial.click();
            txtEmail.click();
            txtEmail.sendKeys(email);
            txtPassword.click();
            txtPassword.sendKeys(password);
            btnLogin.click();
            loginMessage = successfulLoginMessage.getText();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return loginMessage;
    }

    public String invalidCredentials(String email, String password){
        String errorResponseMessage = null;
        Alert alert = driver.switchTo().alert();
        try {
            btnLearningMaterial.click();
            txtEmail.click();
            txtEmail.sendKeys(email);
            txtPassword.click();
            txtPassword.sendKeys(password);
            btnLogin.click();
            errorResponseMessage = alert.getText();
            alert.accept();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("INVALID CREDENTIALS RESPONSE: " + errorResponseMessage);
        return errorResponseMessage;
    }
}
