package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AdvancedMouthInteractions extends CommonMethods{
    @Test
    public void learnAdvancedMouthInteractions() throws InterruptedException {
        WebDriver driver = getDriver();

        Actions actions = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Right')]"));

        actions.doubleClick(doubleClickBtn).build().perform();
        Thread.sleep(3000);

        actions.contextClick(rightClickBtn).build().perform();
        Thread.sleep(3000);

        actions.moveToElement(doubleClickBtn).doubleClick().build().perform();
        Thread.sleep(3000);

       driver.navigate().to("http://the-internet.herokuapp.com/hovers");

       WebElement hoverIcon = driver.findElement(By.xpath("//div[@class='figure'][1]"));

       actions.moveToElement(hoverIcon).build().perform();
       Thread.sleep(3000);

        //click while holding ctrl, to open new tab
       WebElement viewProfileLink = driver.findElement(By.xpath("//div[@class='figure'][1]//a"));
        actions.moveToElement(viewProfileLink).build().perform();
       actions.keyDown(Keys.CONTROL).click(viewProfileLink).keyUp(Keys.CONTROL).build().perform();
       Thread.sleep(3000);


    }

    @Test
    public void learnScroll () throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        loginToSauceDemo();
        Thread.sleep(3000);

        WebElement footer = driver.findElement(By.className("footer_copy"));

        actions.scrollToElement(footer).build().perform();

        Thread.sleep(2000);

        //scroll by the specified amount on the x and y
        actions.scrollByAmount(0,500).build().perform();
    }
    @Test
    public void learnDragAndDrop() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(draggable,droppable).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        actions.dragAndDropBy(slider,1,0).build().perform();


        Thread.sleep(3000);



    }
    @Before
    public void setUp() {
        createDriver("https://demoqa.com/buttons");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
