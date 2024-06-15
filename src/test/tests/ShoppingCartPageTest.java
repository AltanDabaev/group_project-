package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShoppingCartPage;

public class ShoppingCartPageTest extends BaseTest {
    private ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void setUp() {
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test(testName = "Us 310: Remove item from cart")
    public void US310(){
        driver.findElement(By.className("inventory_item_name")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        String  actual =driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
       driver.findElement(By.name("remove-sauce-labs-backpack")).click();
       //String  actual =driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(actual,0);



    }
}





