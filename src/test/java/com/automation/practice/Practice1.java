package com.automation.practice;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice1 extends CommonMethods {

    @Test
    public void practiceOne() throws InterruptedException {
        WebDriver driver = getDriver();

        loginToSauceDemo();

        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Assert.assertTrue("Shopping cart is not visible", cartButton.isDisplayed());
        cartButton.click();
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        Assert.assertTrue("checkout button is not visible",checkoutButton.isDisplayed());
        driver.navigate().back();
        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();
        driver.navigate().forward();
        WebElement itemCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertTrue(itemCart.isDisplayed());


    }


    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
