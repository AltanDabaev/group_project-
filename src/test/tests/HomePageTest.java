package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BrowserUtils;


public class HomePageTest extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;
    public String expectedResult;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.Login();
        report.setAuthor("Marianna");
    }

    @Test(testName = "US304: Navigation menu", description = "When user " +
            "clicks the navigation menu button, 4 options should be displayed: All items," +
            "About, Logout, Reset App State")
    public void US304() {
        homePage.navMenuButton.click();
        new BrowserUtils(driver).waitForVisibilityOf(homePage.item);
        Assert.assertTrue(homePage.item.isDisplayed());
        Assert.assertTrue(homePage.about.isDisplayed());
        Assert.assertTrue(homePage.logout.isDisplayed());
        Assert.assertTrue(homePage.resetAppState.isDisplayed());
         expectedResult = "Navigation menu options " + homePage.item.getText() +
                ", " + homePage.about.getText() +
                ", " + homePage.logout.getText() +
                ", " + homePage.resetAppState.getText() + " are displayed";
    }

    @Test(testName = "US305: Footer Text Test", description = "Verify footer of " +
            "the homepage matches the expected result")
    public void US305(){
       String expectedText = "© 2024 Sauce Labs. All Rights Reserved. " +
               "Terms of Service | Privacy Policy";
       
       Assert.assertEquals(homePage.footer.getText(), expectedText);
       expectedResult = "Footer text is " + expectedText;
    }

    @Test(testName = "US306: Filter Options", description = "When user clicks the filter " +
            "it should have 4 options")
    public void US306(){
        homePage.filterButton.click();
        Assert.assertEquals(homePage.filterOptions.size(), 4);
        Assert.assertEquals(homePage.filterOptions.get(0).getText(), "Name (A to Z)");
        Assert.assertEquals(homePage.filterOptions.get(1).getText(), "Name (Z to A)");
        Assert.assertEquals(homePage.filterOptions.get(2).getText(), "Price (low to high)");
        Assert.assertEquals(homePage.filterOptions.get(3).getText(), "Price (high to low)");

       expectedResult = "Filter options are Name (A to Z), Name (Z to A)," +
                " Price (low to high)," +
                "Price (high to low)";
    }

    @Test(testName = "US307: Social media buttons", description = "Verify 3 social media " +
            "buttons are present: twitter, facebook and linkedIn")
    public void US307() {
        Assert.assertEquals(homePage.socialMediaButtons.size(), 3);
        Assert.assertEquals(homePage.socialMediaButtons.get(0).getText(), "Twitter");
        Assert.assertEquals(homePage.socialMediaButtons.get(1).getText(), "Facebook");
        Assert.assertEquals(homePage.socialMediaButtons.get(2).getText(), "LinkedIn");

        expectedResult = "Social media buttons are Twitter, Facebook, LinkedIn";
    }

        @AfterMethod
        public void end(){
            report.logExpectedResult(expectedResult);
        }
    }
