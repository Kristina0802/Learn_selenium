package com.automation.practice;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Practice2 extends CommonMethods {

    @Test
    public void fillOut() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        WebElement firstName = driver.findElement(By.xpath("//div[@class='control-group']/input[@name='firstname']"));
        firstName.sendKeys("Kristina");
        WebElement lastName = driver.findElement(By.xpath("//div[@class='control-group']/input[@name='lastname']"));
        lastName.sendKeys("Dulyk");
        WebElement gender = driver.findElement(By.xpath("//input[@value='Female']"));
        actions.moveToElement(gender).click(gender).build().perform();
        Thread.sleep(2000);
        WebElement yearsOfEx = driver.findElement(By.xpath("//input[@value='5']"));
        actions.moveToElement(yearsOfEx).click(yearsOfEx).build().perform();
        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys("02/08/2002");
        Thread.sleep(2000);
        WebElement auto = driver.findElement(By.xpath("//input[@value='Automation Tester']"));
        actions.moveToElement(auto).click(auto).build().perform();
        WebElement SWD = driver.findElement(By.xpath("//input[@value='Selenium Webdriver']"));
        actions.moveToElement(SWD).click(SWD).build().perform();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='continents']"));
        Select countries = new Select(dropdown);
        countries.selectByVisibleText("Europe");
        Thread.sleep(2000);
        WebElement seleniumDropdown = driver.findElement(By.xpath("//select[@id='selenium_commands']/option[@style='margin: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;']"));
        actions.moveToElement(seleniumDropdown).click(seleniumDropdown).build().perform();
        Thread.sleep(2000);
        WebElement uploadFile = driver.findElement(By.xpath("//input[@class='input-file']"));
        uploadFile.sendKeys("C:\\Users\\Lian\\Desktop\\TestFile.txt");
        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        button.click();
        Thread.sleep(2000);




    }

    @Before
    public void setUp() {
        createDriver("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
