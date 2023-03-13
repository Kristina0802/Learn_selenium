package Homework;

import com.automation.commons.CommonMethods;
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
//Homework 1
//In a new homework class open https://magento.softwaretestingboard.com/
//Command/Control click on the “Sale” option in the header+
//switchTo() the new opened tab (window)+
//Assert that all of the promotion block are displayed+
//Close the tab and switch back to the primary tab+
//Assert that you are back on the landing page+

public class Homework6 extends CommonMethods {

    @Test
    public void windowsHandlingPractice() throws InterruptedException {

        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        WebElement saleBtn = driver.findElement(By.xpath("//a[@id='ui-id-8']/span"));
        actions.moveToElement(saleBtn).build().perform();
        actions.keyDown(Keys.CONTROL).click(saleBtn).keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        String primaryWindow = driver.getWindowHandle();

        ArrayList<String> windowList = new ArrayList<>(driver.getWindowHandles());

        for (String windows : windowList) {
            if (!windows.equals(primaryWindow)) {
                driver.switchTo().window(windows);
                Thread.sleep(1000);
                if (driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/sale.html")) {
                    WebElement promotionBlock = driver.findElement(By.className("blocks-promo"));
                    Assert.assertTrue("Promotion block are not displayed", promotionBlock.isDisplayed());
                    System.out.println(promotionBlock.getText());
                    driver.close();
                    Thread.sleep(1000);
                } else {
                    driver.close();
                }
            }
        }
        driver.switchTo().window(primaryWindow);
        Assert.assertTrue("You are not in main page", saleBtn.isDisplayed());
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
