package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BrowserNavigation extends CommonMethods {

    @Test
    public void learnBrowserNavigation() throws InterruptedException {
        WebDriver driver = getDriver();

        //opens up diff url in the same driver session
        driver.navigate().to("http://18.116.88.132:8080/bank/login");
        Thread.sleep(3000);
        //will bring you to the original url
        driver.navigate().back();
        Thread.sleep(3000);
        //does the opposite of the back method and will essentially undo the back(); method
        driver.navigate().forward();

        Thread.sleep(3000);

        //will refresh the current page
        driver.navigate().refresh();

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
