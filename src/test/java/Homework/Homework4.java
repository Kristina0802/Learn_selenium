package Homework;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//In a new Homework class open this page: https://magento.softwaretestingboard.com/
//Once on the page scroll down to the bottom of the page where the “Hot Sellers” section is visible
//Select an item and hover over it
//While hovering assert that the add to cart button is visible then select the size and color
//Once item is added to cart page should reload
//After page has been reloaded you can proceed to check out. (Either through the cart icon or the cart page)
//Once on checkout page fill out the form USE FAKE INFO (Try to challenge yourself and use complex locators)
//Once you reach Review & Payments assert that the info you entered is the info displayed
//Then hit place order and assert that your order has been placed by checking the success screen.

public class Homework4 extends CommonMethods {

    @Test
    public void mouthInteraction() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        WebElement hotSellers = driver.findElement(By.xpath("//h2[@class='title']"));
        actions.scrollToElement(hotSellers).build().perform();
        Thread.sleep(3000);
        WebElement hoverOverElement = driver.findElement(By.xpath("//a[@title='Radiant Tee']"));
        actions.moveToElement(hoverOverElement).build().perform();
        Thread.sleep(3000);
        WebElement addToCart = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        Assert.assertTrue("Add to cart button is not displayed",addToCart.isDisplayed());

        WebElement selectSize = driver.findElement(By.xpath("//div[@class='swatch-option text']"));
        actions.click(selectSize).build().perform();
        Thread.sleep(1000);
        WebElement selectColor = driver.findElement(By.xpath("//*[@id='option-label-color-93-item-56']"));
        actions.click(selectColor).build().perform();
        actions.click(addToCart).build().perform();
        Thread.sleep(1000);

        WebElement cartPage = driver.findElement(By.xpath("//a[@class='action showcart']"));
        actions.click(cartPage).build().perform();
        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id='top-cart-btn-checkout']"));
        actions.click(proceedToCheckout).build().perform();

        Thread.sleep(2000);

        WebElement emailInput = driver.findElement(By.xpath("//div[@class='control _with-tooltip']/input[@class='input-text']"));
        emailInput.sendKeys("Kristina2002@gmail.com");
        WebElement firstName = driver.findElement(By.xpath("//div[@class='control']/input[@name='firstname']"));
        firstName.sendKeys("Jim");
        WebElement lastName = driver.findElement(By.xpath("//div[@class='control']/input[@name='lastname']"));
        lastName.sendKeys("Boden");
        WebElement company = driver.findElement(By.xpath("//div[@class='control']/input[@name='company']"));
        company.sendKeys("Universal Ways");
        WebElement street = driver.findElement(By.xpath("//div[@class='control']/input[@name='street[0]']"));
        street.sendKeys("Syracuse,st");
        WebElement city = driver.findElement(By.xpath("//div[@class='control']/input[@name='city']"));
        city.sendKeys("New York");
        WebElement state = driver.findElement(By.xpath("//select[@name='region_id']"));
        Select stateDropdowns = new Select(state);
        stateDropdowns.selectByVisibleText("New York");
        Thread.sleep(2000);
        WebElement postalCode = driver.findElement(By.xpath("//div[@class='control']/input[@name='postcode']"));
        postalCode.sendKeys("32748");
        WebElement country = driver.findElement(By.xpath("//div[@class='control']/select[@name='country_id']"));
        Select counties = new Select(country);
        counties.selectByVisibleText("United States");
        Thread.sleep(2000);
        WebElement phoneNumber = driver.findElement(By.xpath("//div[@class='control _with-tooltip']/input[@name='telephone']"));
        phoneNumber.sendKeys("1123546548");
        WebElement checkBox = driver.findElement(By.xpath("//td[@class='col col-method']/input[@value='tablerate_bestway']"));
        actions.click(checkBox).build().perform();
        Thread.sleep(2000);
        WebElement next = driver.findElement(By.xpath("//div[@class='primary']/button[@class='button action continue primary']"));
        actions.click(next).build().perform();
        Thread.sleep(2000);


        WebElement assertInfoIsDisplayed = driver.findElement(By.xpath("//div[@class='billing-address-details']"));
        Assert.assertTrue("Info is not displayed", assertInfoIsDisplayed.isDisplayed());

        WebElement placeOrder = driver.findElement(By.xpath("//button[@title='Place Order']/span"));
        actions.click(placeOrder).build().perform();

        WebElement successfulOrder = driver.findElement(By.xpath("//span[contains(text(),'Thank you for your purchase!')]"));
        Assert.assertTrue("Order wasn't placed successfully", successfulOrder.isDisplayed());
        System.out.println(successfulOrder.getText());
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
