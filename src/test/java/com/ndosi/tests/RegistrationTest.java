package com.ndosi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ndosi.core.BrowserFactory;
import com.ndosi.pages.Registration;

import net.datafaker.Faker;

public class RegistrationTest extends BrowserFactory{

    Faker faker = new Faker();
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String emailAddress = faker.internet().emailAddress();
    String password = "Abc123@!";
    String confirmPassword = "Abc123@!";

    @Test
    public void successfulAccountCreated(){
        Assert.assertEquals(new Registration(driver).createAccount(firstname, lastname, emailAddress, password, confirmPassword).equals("Registration successful! Please login with your credentials."), true);
    }

    @Test
    public void passwordMismatch(){
        Assert.assertEquals(new Registration(driver).createAccount(firstname, lastname, emailAddress, "12345", "abc12345").equals("Passwords do not match!"), true);
    }

    @Test
    public void invalidEmailAddress(){
        Assert.assertEquals(new Registration(driver).createAccount(firstname, lastname, "test.co.za", password, confirmPassword).equals("Please enter a valid email address"), true);
    }

    @Test
    public void passwordLength(){
        Assert.assertEquals(new Registration(driver).createAccount(firstname, lastname, emailAddress, "12345", "12345").equals("Password must be at least 8 characters long"), true);
    }

    @Test
    public void emptyFields(){
        Assert.assertEquals(new Registration(driver).createAccount("", "", emailAddress, password, confirmPassword).equals("Please fill in all fields"), true);
    }

    @Test
    public void userAlreadyExist(){
        Assert.assertEquals(new Registration(driver).createAccount("test", "test", "test@test.co.za", "test1234", "test1234").equals("Registration failed: User already exists"), true);
    }

}
