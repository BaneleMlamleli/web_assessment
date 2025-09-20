package com.ndosi.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ndosi.core.BrowserFactory;
import com.ndosi.pages.Home;

public class HomeTest extends BrowserFactory{

    Logger logger = LogManager.getLogger(HomeTest.class.getName());

    @Test
    public void verifyLandingOnHomePage(){
        logger.info("**** Landing on Home Page method executed****");
        System.out.println("**** Landing on Home Page method executed****");
        try {
            Assert.assertTrue(new Home(driver).verifyUserIsOnHomePage() == 7, "Fail. Number of navigation headers has changed");

            Assert.assertTrue(new Home(driver).verifyLoginViewIsDisplayed(), "Fail. Login view is not displayed");
        } catch (Exception e) {
            logger.error("Class: {}", HomeTest.class.getName(), e);
            System.out.println("Class: " + HomeTest.class.getName() + "Exception caught: " + e.getMessage());
        }
    }
}
