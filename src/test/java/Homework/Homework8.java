package Homework;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homework8 extends CommonMethods {

    @Test
    public void findAlert() throws InterruptedException{
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frm1']"));
        driver.switchTo().frame(frame1);

        WebElement drop = driver.findElement(By.id("selectnav1"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", drop);
        Select dropOptions = new Select(drop);

        driverWait.until(ExpectedConditions.textToBePresentInElement(drop, "- Alerts"));
        dropOptions.selectByVisibleText("- Alerts");
        Thread.sleep(2000);
        WebElement clickBtn = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickBtn.click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();

        Thread.sleep(2000);
        Assert.assertEquals("I am an alert box!", alert.getText());
        alert.accept();
    }







    @Before
    public void setUp() {
        createDriver("https://www.hyrtutorials.com/p/frames-practice.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
