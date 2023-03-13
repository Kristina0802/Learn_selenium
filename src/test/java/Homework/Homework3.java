package Homework;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
//Create a test method in a new Homework2 class to:
//Open and login to saucedemo.com
//Then click on the filter and select Price (low to high) (Seem image attached below)
//Assert that the span with active-option class value has changed to the option you selected
//Now refresh the page and ensure that the filter changed back to its original state


public class Homework3 extends CommonMethods {

    @Test
    public void filterSelector() throws InterruptedException {
        WebDriver driver = getDriver();
        loginToSauceDemo();

        WebElement priceFilter = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        priceFilter.click();
        Select priceDropdown = new Select(priceFilter);

        Thread.sleep(3000);

        priceDropdown.selectByVisibleText("Price (low to high)");
        WebElement lowToHigh = driver.findElement(By.xpath("//option[@value='lohi']"));
        lowToHigh.click();
        Assert.assertTrue("The span didn't change after selecting",lowToHigh.getText().contains("Price (low to high)"));
        Thread.sleep(3000);
        driver.navigate().refresh();

    }



    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com/inventory.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
