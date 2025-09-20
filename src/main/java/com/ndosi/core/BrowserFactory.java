package com.ndosi.core;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ndosi.utils.ConfigReader;

public class BrowserFactory {

    protected WebDriver driver;
    final String BROWSER = new ConfigReader().getProperty("browser");
    final String BASE_URL = new ConfigReader().getProperty("baseUrl");

    public Logger logger = LogManager.getLogger(new Object() {
    }.getClass().getName());


    @BeforeClass
    public void initBrowser(){
        logger.info("**** Initiating browser ****");
        logger.info("**** Browser:\t"+BROWSER+" ****");
        logger.info("**** URL:\t"+BASE_URL+"****");
        System.out.println("**** Initiating browser ****");
        System.out.println("**** Browser:\t"+BROWSER+" ****");
        System.out.println("**** URL:\t"+BASE_URL+"****");
        switch (BROWSER) {
            case "chrome":
                logger.info("**** Chrome browser ****");
                System.out.println("**** Chrome browser ****");
                driver = new ChromeDriver();
                driver.get(BASE_URL);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                break;
            case "firefox":
                logger.info("**** Firefox browser ****");
                System.out.println("**** Firefox browser ****");
                driver = new FirefoxDriver();
                driver.get(BASE_URL);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                break;
            case "edge":
                logger.info("**** Edge browser ****");
                System.out.println("**** Edge browser ****");
                driver = new EdgeDriver();
                driver.get(BASE_URL);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                break;
            default: 
                logger.error(
                        "Entered browser '" + BROWSER + "' is not configured in the method '" + new Object() {
                        }.getClass().getEnclosingMethod().getName() + "'");
                System.out.println(
                        "Entered browser '" + BROWSER + "' is not configured in the method '" + new Object() {
                        }.getClass().getEnclosingMethod().getName() + "'");break;
        }
    }

    @AfterClass
    public void terminateBrowser(){
        if (driver != null) {
            driver.close();
            driver = null;
            // driver.quit();
        }
    }

}
