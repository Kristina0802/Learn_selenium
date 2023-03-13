package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DayTwo extends DriverUtils {

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void login() throws InterruptedException{

        WebDriver driver = getDriver();

        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        //Login
        loginInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        Thread.sleep(500);
        WebElement productsPageTitle = driver.findElement(By.className("title"));

        Assert.assertTrue("Not on products page", productsPageTitle.isDisplayed());

        List<WebElement> inventoryItemDescriptions =  driver.findElements(By.className("inventory_item_desc"));

        for(WebElement webElements : inventoryItemDescriptions ) {
            System.out.println(webElements.getText());
        }


        Thread.sleep(5000);


    }
    @After
    public void cleanUp(){
        quitDriver();
    }
}
