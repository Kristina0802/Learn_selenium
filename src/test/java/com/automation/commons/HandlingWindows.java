package com.automation.commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Set;

public class HandlingWindows extends CommonMethods {
    @Test
    public void LearnHandlingWindow() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.navigate().to("https://demoqa.com/browser-windows");
        WebElement tabBtn = driver.findElement(By.id("tabButton"));
        WebElement windowBtn = driver.findElement(By.id("windowButton"));

        //Here we are saving the window handle of the current window as String variable so that we can return to it later
        String primaryWindow = driver.getWindowHandle();

        tabBtn.click();
        windowBtn.click();
        Thread.sleep(2000);

        //here we are taking the return type of Set<String> and casting it to an ArrayList<String> for easy access
        //to .get() method
        Set<String> windowSet = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>(windowSet);
        //We are creating a for loop to cycle through elements of the windows list then we are making sure that
        //the current window isn't the primary window we were originally in
        for (String windows : windowsList){
            if(!windows.equals(primaryWindow)){
                Thread.sleep(2000);
                //here we are switching to the current window that passed all above conditions
                driver.switchTo().window(windows);
                WebElement header = driver.findElement(By.tagName("h1"));
                System.out.println(header.getText());
                //this method closes specific window that currently active
                driver.close();
            }
        }
        driver.switchTo().window(primaryWindow);

    }
    @Test
    public void windowHandlingExample() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/");

        Actions actions = new Actions(driver);

        String primaryWindow = driver.getWindowHandle();

        WebElement shopNewYogaBtn = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));

        actions.keyDown(Keys.CONTROL).click(shopNewYogaBtn).keyUp(Keys.CONTROL).build().perform();
        //passing into the constructor of ArrayList which will cast it to ArrayList
        ArrayList<String> windowList = new ArrayList<>(driver.getWindowHandles());

        for(String windowHandle : windowList){
            if (!windowHandle.equals(primaryWindow)) {
                driver.switchTo().window(windowHandle);

                if(driver.getCurrentUrl().contains("/collections/yoga-new.html")){

                }else {
                    driver.close();
                }
            }
        }
        //here on out we are in new window
        WebElement category = driver.findElement(By.xpath("//li[@class='item category8']/strong"));

        Assert.assertTrue("Category does not match expected", category.getText().equalsIgnoreCase("new luma yoga collection"));


        Thread.sleep(2000);

        //closing the current tab
        driver.close();

        driver.switchTo().window(primaryWindow);

        shopNewYogaBtn = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));

        Assert.assertTrue("Shop new yoga button not visible", shopNewYogaBtn.isDisplayed());

    }



    @Before
    public void setUp() {
        createDriver("https://demoqa.com/browser-windows");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
