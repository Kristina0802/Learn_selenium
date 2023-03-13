package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlingIframes extends CommonMethods {

    @Test
    public void IFrameHandling() throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));

        //here we are switching into the iframe1
        driver.switchTo().frame(iframe1);

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        //here we are going to the parent frame  after entering the child frame
        driver.switchTo().parentFrame();

        Thread.sleep(2000);

    }
    @Test
    public void learnNestedIframeHandling() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.navigate().to("https://demoqa.com/nestedframes");

        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        Thread.sleep(2000);

        WebElement frame2 = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(frame2);

        System.out.println(driver.findElement(By.tagName("p")).getText());

        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("body")).getText());

        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }



    @Before
    public void setUp() {
        createDriver("https://demoqa.com/frames");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
