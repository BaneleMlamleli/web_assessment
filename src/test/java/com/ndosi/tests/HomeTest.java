package com.ndosi.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
            System.out.println("List of navigation bar: " + new Home(driver).verifyUserIsOnHomePage());
        } catch (Exception e) {
            logger.error("Class: {}", HomeTest.class.getName(), e);
            System.out.println("Class: " + HomeTest.class.getName() + "Exception caught: " + e.getMessage());
        }
    }
}
