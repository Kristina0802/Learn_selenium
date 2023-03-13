package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {

    private static WebDriver driver;

    public void createDriver(String url){
        System.setProperty("webdriver.chrome.driver","src/test/java/driver/chromedriver.exe");

         driver = new ChromeDriver();

        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //to maximize the window
        driver.manage().window().maximize();
    }
    public void quitDriver(){
        driver.close();
        driver.quit();
    }
    public WebDriver getDriver(){
        return driver;
    }
}
