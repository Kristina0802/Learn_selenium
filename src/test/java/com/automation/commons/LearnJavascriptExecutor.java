package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearnJavascriptExecutor extends CommonMethods{

    @Test
    public void LearnJsExecutor() throws InterruptedException {
        WebDriver driver = getDriver();
        //creating instance by typecasting it to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement hotSellersTitle = driver.findElement(By.xpath("//h2[@class='title']"));

        Thread.sleep(3000);
        //Here we are calling the .executeScript method and passing a JS snippet (script) in order to scroll down by
        //500 pixels
        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000);

        //here we are retrieving the Y coordinate of the hotSellersTitle WebElement on the page
        int yPositionOfHotSellers = hotSellersTitle.getLocation().getY();

        //here we are passing the y value of the hotSellersTitle position and concatenating it to the string script
        js.executeScript("window.scrollBy(0,"+yPositionOfHotSellers+")");
        Thread.sleep(2000);

        //here we are using diff script and passing a variable WebElement as an argument to the JS script
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", hotSellersTitle);

        Thread.sleep(2000);



    }


    @Before
    public void setUp() {
        createDriver("https://magento.softwaretestingboard.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
