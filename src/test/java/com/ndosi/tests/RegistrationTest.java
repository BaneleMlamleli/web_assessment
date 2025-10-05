package com.ndosi.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ndosi.core.BrowserFactory;
import com.ndosi.pages.Registration;

import net.datafaker.Faker;

@Listeners(com.ndosi.utils.ExtentReportsUtil.class)
public class RegistrationTest extends BrowserFactory{

    Faker faker = new Faker();
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String emailAddress = faker.internet().emailAddress();
    String password = "Abc123@!";
    String confirmPassword = "Abc123@!";

    Logger logger = LogManager.getLogger(new Object(){}.getClass().getName());

    @Test
    public void successfulAccountCreated(){
        try {
            Assert.assertEquals(new Registration(driver).createAccount(firstname, lastname, emailAddress, password, confirmPassword), "Registration successful! Please login with your credentials.");
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
            e.printStackTrace();
        }
    }

    @Test
    public void passwordMismatch(){
        try {
            Assert.assertEquals(new Registration(driver).createAccount(firstname, lastname, emailAddress, "12345", "abc12345"),"Passwords do not match!");
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
            e.printStackTrace();
        }
    }

    @Test
    public void invalidEmailAddress(){
        logger.info("**** method \'invalidEmailAddress\' executed ****");
        try {
            Assert.assertEquals(new Registration(driver).createAccount(firstname, lastname, "test.co.za", password, confirmPassword), "Please enter a valid email address");
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
            // e.printStackTrace();
        }
    }

    @Test
    public void passwordLength(){
        try {
            Assert.assertEquals(new Registration(driver).createAccount(firstname, lastname, emailAddress, "12345", "12345").equals("Password must be at least 8 characters long"), true);
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
            e.printStackTrace();
        }
    }

    @Test
    public void emptyFields(){
        try {
            Assert.assertEquals(new Registration(driver).createAccount("", "", emailAddress, password, confirmPassword).equals("Please fill in all fields"), true);
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
            e.printStackTrace();
        }
    }

    @Test
    public void userAlreadyExist(){
        try {
            Assert.assertEquals(new Registration(driver).createAccount("test", "test", "test@test.co.za", "test1234", "test1234").equals("Registration failed: User already exists"), true);
        } catch (Exception e) {
            logger.error("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
            e.printStackTrace();
        }
    }

}
