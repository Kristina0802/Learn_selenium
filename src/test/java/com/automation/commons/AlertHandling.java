package com.automation.commons;

import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandling extends CommonMethods {

    @Test
    public void learnAlertHandling() throws InterruptedException {
        WebDriver driver = getDriver();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement btn1 = driver.findElement(By.id("alertButton"));
        WebElement btn2 = driver.findElement(By.id("timerAlertButton"));
        WebElement btn3 = driver.findElement(By.id("confirmButton"));
        WebElement btn4 = driver.findElement(By.id("promtButton"));

        btn1.click();
        //creating instance of this interface, will retrieve the current alert that we see
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        System.out.println(alert.getText());
        alert.dismiss();

        btn2.click();
        // Explicit wait to wait for the alert to show up
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        alert.dismiss();

        btn3.click();
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        //alert.accept(); or
        alert.dismiss();

        btn4.click();
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert= driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("Hello World");
        alert.accept();

        Thread.sleep(3000);


        Alert alert1 = driverWait.until(ExpectedConditions.alertIsPresent());





    }


    @Before
    public void setUp() {
        createDriver("https://demoqa.com/alerts");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
