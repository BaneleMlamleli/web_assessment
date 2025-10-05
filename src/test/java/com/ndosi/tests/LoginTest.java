package com.ndosi.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ndosi.core.BrowserFactory;
import com.ndosi.pages.Login;
import com.ndosi.utils.ConfigReader;

@Listeners(com.ndosi.utils.ExtentReportsUtil.class)
public class LoginTest extends BrowserFactory{

    final String username = new ConfigReader().getProperty("username");
    final String password = new ConfigReader().getProperty("password");

    @Test(priority = 1)
    public void emptyFields(){
        Assert.assertEquals(new Login(driver).invalidCredentials("", ""),"Please enter both email and password");
    }
    
    @Test(priority = 2)
    public void wrongUsernameAndEmptyPasswordField(){
        Assert.assertEquals(new Login(driver).invalidCredentials("wrong_username", ""),"Please enter both username and password");
    }

    @Test(priority = 3)
    public void emptyUsernameFieldAndWrongPassword(){
        Assert.assertEquals(new Login(driver).invalidCredentials("", "wrong_password"),"Please enter both username and password");
    }

    @Test(priority = 4)
    public void invalidLoginDetails(){
        Assert.assertEquals(new Login(driver).invalidCredentials("wrong_username", "wrong_password"),"Invalid email or password");
    }

    @Test(priority = 5)
    public void validLoginDetails(){
        Assert.assertEquals(new Login(driver).validCredentials(username, password), "Welcome back, Shane!");
    }
}
