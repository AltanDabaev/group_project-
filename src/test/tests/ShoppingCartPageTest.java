package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import utils.BrowserUtils;

public class ShoppingCartPageTest extends BaseTest{
    private ShoppingCartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        cartPage = new ShoppingCartPage(driver);
    }

    @Test(testName = "US 309:  Add to cart")
    public void US309() throws InterruptedException {
        cartPage.addCard.click();
        cartPage.shopCardConteiner.click();
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.item.isDisplayed());




    }
}
