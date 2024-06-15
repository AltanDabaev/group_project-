package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import utils.BrowserUtils;

public class CheckoutPageTest extends BaseTest {
    private CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        checkoutPage = new CheckoutPage(driver);
    }

    @Test(testName = "US 308: Checkout Information")
    public void US308() throws InterruptedException {
        checkoutPage.shopCardConteiner.click();
        checkoutPage.checkPage.click();
        Assert.assertTrue(checkoutPage.firstName.isDisplayed());
        Assert.assertTrue(checkoutPage.lastName.isDisplayed());
        Assert.assertTrue(checkoutPage.postalCode.isDisplayed());
    }


}
