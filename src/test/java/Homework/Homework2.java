package Homework;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homework2 extends DriverUtils {
    @Before
    public void setUp(){
        createDriver("https://www.timeanddate.com/timer/");//open website
    }
    @Test
    public void timerVerification(){
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));//create diver to explicitly wait for condition to be true
        //or wait certain time(30 sec)

        WebElement startAndPauseButton = driver.findElement(By.xpath("//button[@title='Start timer']"));
        //locator for start and pause button
        WebElement resetButton = driver.findElement(By.xpath("//button[@title='Reset and start over']"));
        //locator for reset button
        WebElement progressBar = driver.findElement(By.xpath("//span[@class='timeLeft']"));
        //timer
        startAndPauseButton.click();

        driverWait.until(ExpectedConditions.textToBePresentInElement(progressBar, "00:01:45"));
        startAndPauseButton.click();
        //explicit wait condition

        Assert.assertTrue("Time did not match expected", progressBar.getText().contains("00:01:45"));
        resetButton.click();
        //assertion to make sure we'll get to a expected numbers in timer

        Assert.assertTrue("Time was not reset",progressBar.getText().contains("00:02:00"));
        //assertion to make sure reset button was clicked
    }
    @After
    public void cleanUp(){//close website
        quitDriver();
    }
}
