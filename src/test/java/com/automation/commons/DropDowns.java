package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDowns extends CommonMethods{

    @Test
    public void learnDropdowns() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

        Thread.sleep(3000);
        WebElement dropDown = driver.findElement(By.xpath("//select"));

        WebElement selectCountryTitle = driver.findElement(By.id("Select Country"));

        System.out.println(selectCountryTitle.getAttribute("id"));
        System.out.println(selectCountryTitle.getAttribute("class"));
        System.out.println(selectCountryTitle.getAttribute("aria-controls"));
        System.out.println(selectCountryTitle.getAttribute("role"));

        System.out.println("--------------------------");
        Select countriesDropDown = new Select(dropDown);

        List<WebElement> optionsList = countriesDropDown.getOptions();

        for(WebElement option : optionsList){
            System.out.println(option.getText()+"\t"+option.getAttribute("value"));
        }
        System.out.println(countriesDropDown.getOptions().get(1).getText());
        countriesDropDown.selectByVisibleText("Ukraine");



        Thread.sleep(3000);

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
