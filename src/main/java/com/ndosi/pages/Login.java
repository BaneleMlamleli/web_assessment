package com.ndosi.pages;

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

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void invalidEmail(){}

    public boolean invalidLoginCredentials(){
        return true;
    }

    public boolean validCredentials(){
        return true;
    }



}
