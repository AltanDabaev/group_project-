package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;

import java.util.List;

public class ShoppingCartPageTest extends BaseTest {

    private ShoppingCartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        cartPage = new ShoppingCartPage(driver);
    }

    @Test(testName = "US 309:  Add to cart")
    public void US309() throws InterruptedException {
        cartPage.addCard.click();
        cartPage.shopCardConteiner.click();
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.allItems.get(0).isDisplayed());
    }

    @Test(testName = "Us 310: Remove item from cart", description = "remove item" + "the shoppingCartPage  expected 0")
    public void US310() throws InterruptedException {
        cartPage.usernameInputField.sendKeys("standard_user");
        cartPage.passwordInputField.sendKeys("secret_sauce");
        cartPage.loginBtn.click();
        cartPage.addCard.click();
        cartPage.shopCardConteiner.click();
        Thread.sleep(1000);
        cartPage.allItems.get(0).isDisplayed();
        cartPage.removeBtn.click();
        List<WebElement>list=cartPage.allItems;
        Assert.assertEquals(list.size(),0);

//        driver.findElement(By.className("inventory_item_name")).click();
//        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
//        //driver.findElement(By.xpath("//div[@class=:'inventory_item_name']")).getText();
//        String actual = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
//        driver.findElement(By.name("remove-sauce-labs-backpack")).click();
//        //String  actual =driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
//        Assert.assertEquals(actual, 0);
//        @AfterMethod
//        public void end(){
//            report.logExpectedResult(expectedResult);
        }
    }






