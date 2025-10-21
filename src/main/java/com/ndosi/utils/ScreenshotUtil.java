package com.ndosi.utils;

import java.io.File;
import java.io.IOException;
import java.lang.StackWalker.StackFrame;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    // WebDriver driver;

    // public ScreenshotUtil(WebDriver driver) {
    //     this.driver = driver;
    // }

    public static Logger logger = LogManager.getLogger(new Object() {
    }.getClass().getName());

    public static void screenShot(WebDriver driver, String failedImageFile) {
        logger.info("**** Executing screenShot method in the ScreenshotUtil class ****");
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/src/test/reports/screenshot/",failedImageFile + ".png");
            FileUtils.copyFile(src, destination);
            logger.info("Successfully captured a screenshot");
        } catch (IOException ioe) {
            logger.error("**** IOException while taking screenshot ****");
            logger.error("'" + ioe.getMessage() + "' in method '" + StackWalker.getInstance().walk(frames -> frames.skip(0).findFirst().map(StackFrame::getMethodName).orElse("<Unknown>")) + "'");
            ioe.printStackTrace();
        } catch (Exception e) {
            logger.error("**** Exception while taking screenshot ****");
            logger.error("'" + e.getMessage() + "' in method '" + StackWalker.getInstance().walk(frames -> frames.skip(0).findFirst().map(StackFrame::getMethodName).orElse("<Unknown>")) + "'");
            e.printStackTrace();
        }
    }
}