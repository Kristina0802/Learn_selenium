package Homework;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Homework5 extends CommonMethods {

    @Test
    public void mouthInteractions() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement hotSellers = driver.findElement(By.xpath("//h2[@class='title']"));
        int hotSellersPosition = hotSellers.getLocation().getY();

        js.executeScript("window.scrollBy(0,"+hotSellersPosition+")");
        //first approach
//        WebElement hoverOverElement = driver.findElement(By.xpath("//a[@title='Radiant Tee']"));
//        actions.moveToElement(hoverOverElement).build().perform();
//        Thread.sleep(1000);
//        WebElement hoverOverBreatheEasy = driver.findElement(By.xpath("//a[@title='Breathe-Easy Tank']"));
//        actions.moveToElement(hoverOverBreatheEasy).build().perform();
//        Thread.sleep(1000);
//        WebElement hoverOverArgus = driver.findElement(By.xpath("//a[@title='Argus All-Weather Tank']"));
//        actions.moveToElement(hoverOverArgus).build().perform();
//        Thread.sleep(1000);
        //second approach
        List<WebElement> listOfItems = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        List<WebElement> addToCartBtn = driver.findElements(By.xpath("//button[@title='Add to Cart']//span"));

        for(int i = 0; i< listOfItems.size();i++){
            actions.moveToElement(listOfItems.get(i)).build().perform();
            actions.scrollToElement(addToCartBtn.get(i)).build().perform();
            Assert.assertTrue("Add to cart button is not visible",addToCartBtn.get(i).isDisplayed());

        }





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
