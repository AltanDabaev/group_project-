package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BrowserUtils;


public class HomePageTest extends BaseTest{

    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        homePage = new HomePage(driver);
    }

    @Test(testName = "US304: Navigation menu")
    public void US304() throws InterruptedException {
        homePage.navMenuButton.click();
        new BrowserUtils(driver).waitForVisibilityOf(homePage.allItems);
        Assert.assertTrue(homePage.allItems.isDisplayed());
        Assert.assertTrue(homePage.about.isDisplayed());
        Assert.assertTrue(homePage.logout.isDisplayed());
        Assert.assertTrue(homePage.resetAppState.isDisplayed());
    }

    @Test(testName = "US305: Footer Text Test")
    public void US305(){
       String expectedText = "© 2024 Sauce Labs. All Rights Reserved. " +
               "Terms of Service | Privacy Policy";
       Assert.assertEquals(homePage.footer.getText(), expectedText);
    }

    @Test(testName = "US306: Filter Options")
    public void US306(){
        homePage.filterButton.click();
        Assert.assertEquals(homePage.filterOptions.size(), 4);
        Assert.assertEquals(homePage.filterOptions.get(0).getText(), "Name (A to Z)");
        Assert.assertEquals(homePage.filterOptions.get(1).getText(), "Name (Z to A)");
        Assert.assertEquals(homePage.filterOptions.get(2).getText(), "Price (low to high)");
        Assert.assertEquals(homePage.filterOptions.get(3).getText(), "Price (high to low)");

    }

    @Test(testName = "US307: Social media buttons")
    public void US307(){
        Assert.assertEquals(homePage.socialMediaButtons.size(), 3);
        Assert.assertEquals(homePage.socialMediaButtons.get(0).getText(), "Twitter");
        Assert.assertEquals(homePage.socialMediaButtons.get(1).getText(), "Facebook");
        Assert.assertEquals(homePage.socialMediaButtons.get(2).getText(), "LinkedIn");
    }
}
