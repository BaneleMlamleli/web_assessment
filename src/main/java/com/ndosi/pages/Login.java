package com.ndosi.pages;

import java.lang.StackWalker.StackFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ndosi.utils.WaitsFactory;

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

    WaitsFactory waitsFactory;

    Logger logger = LogManager.getLogger(new Object(){}.getClass().getName());


    public Login(WebDriver driver){
        this.driver = driver;
        waitsFactory = new WaitsFactory(driver);
        PageFactory.initElements(driver, this);
    }

    public String validCredentials(String email, String password){
        String loginMessage = null;
        try {
            waitsFactory.explicitWait(btnLearningMaterial);
            btnLearningMaterial.click();
            txtEmail.sendKeys(email);
            txtPassword.sendKeys(password);
            waitsFactory.explicitWaitButtonClickable(btnLogin);
            btnLogin.click();
            loginMessage = successfulLoginMessage.getText();
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + StackWalker.getInstance().walk(frames -> frames.skip(0).findFirst().map(StackFrame::getMethodName).orElse("<Unknown>")) + "'");
            e.printStackTrace();
        }
        return loginMessage;
    }

    public String invalidCredentials(String email, String password){
        System.out.println("******* invalidCredentials clicked");
        logger.info(password);
        String errorResponseMessage = null;
        Alert alert = driver.switchTo().alert();
        try {
            waitsFactory.explicitWait(btnLearningMaterial);
            System.out.println("******* inside the try-catch");
            btnLearningMaterial.click();
            txtEmail.sendKeys(email);
            txtPassword.sendKeys(password);
            waitsFactory.explicitWaitButtonClickable(btnLogin);
            btnLogin.click();
            errorResponseMessage = alert.getText();
            System.out.println("******* Last line of try-catch");
            alert.accept();
            alert.dismiss();
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + StackWalker.getInstance().walk(frames -> frames.skip(0).findFirst().map(StackFrame::getMethodName).orElse("<Unknown>")) + "'");
            e.printStackTrace();
        }
        return errorResponseMessage;
    }
}
