package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserSynchronization extends DriverUtils {

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/progress-bar");
    }
    @Test
    public void learnWaits()  {
        WebDriver driver = getDriver();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement startButton = driver.findElement(By.xpath("//button[@id='startStopButton']"));

        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar div.progress-bar"));

        startButton.click();

        driverWait.until(ExpectedConditions.textToBePresentInElement(progressBar,"100%"));

        Assert.assertTrue("Value does not match expected", progressBar.getText().contains("100%"));
    }
    @After
    public void cleanUp(){
        quitDriver();
    }
}
