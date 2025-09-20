package com.ndosi.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    WebDriver driver;
    @FindBy(id = "nav-btn-overview")
    protected WebElement btnHome;

    @FindBy(id = "nav-tabs")
    protected List<WebElement> lstNavigationBar;

    @FindBy(id = "nav-btn-practice")
    protected WebElement btnLearningMaterial;

    Logger logger = LogManager.getLogger(new Object() {
    }.getClass().getName());
    
    public Home(WebDriver driver){
        logger.info("**** Executing constructor for Home class ****");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int verifyUserIsOnHomePage(){
        logger.info("**** Xxx ****");
        int navBarList = lstNavigationBar.size();
        btnHome.click();
        btnLearningMaterial.click();
        return navBarList;
    }

}
