package Homework;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//        Homework 2
//In a new homework class open https://www.hyrtutorials.com/p/frames-practice.html+
//Scroll down so that the “Frame2:” is visible this iFrame should be talking about “Basic Controls in HTML”+
//Switch to the frame and fill out the form WITH FAKE INFO+
public class Homework7 extends CommonMethods {


    @Test
    public void iframeHandles() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);
        WebElement frame2 = driver.findElement(By.id("frm2"));
        actions.scrollToElement(frame2).build().perform();
        driver.switchTo().frame(frame2);
        Thread.sleep(3000);
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Kris");
        WebElement lastName = driver.findElement(By.xpath("//div[@class='basicControls']/input[@id='lastName']"));
        lastName.sendKeys("Jones");
        WebElement gender = driver.findElement(By.xpath("//input[@id='femalerb']"));
        gender.click();
        Thread.sleep(1000);
        WebElement knownLanguages = driver.findElement(By.xpath("//input[@id='englishchbx']"));
        knownLanguages.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("Kris02082002@gmail.com");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("p@ssword!");
        WebElement register = driver.findElement(By.xpath("//div[@align='center']/button[@id='registerbtn']"));
        register.click();
        Thread.sleep(5000);




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
