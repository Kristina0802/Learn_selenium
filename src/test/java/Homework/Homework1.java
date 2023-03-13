package Homework;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework1 extends DriverUtils {

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void addToCart() throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        loginInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        Thread.sleep(2000);

        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        Thread.sleep(2000);
        WebElement cartPageButton = driver.findElement(By.className("shopping_cart_link"));
        cartPageButton.click();
        Thread.sleep(2000);
        WebElement backPack = driver.findElement(By.className("inventory_item_name"));
        Assert.assertTrue("Item not added to cart", backPack.isDisplayed());
        WebElement removeItem = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeItem.click();
        Thread.sleep(2000);
        WebElement continueShopping = driver.findElement(By.id("continue-shopping"));
        continueShopping.click();


    }
    @After
    public void cleanUp(){
        quitDriver();
    }
}
