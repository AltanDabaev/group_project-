package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest{
    private LoginPage loginPage;
    private String expectedResult;

    private WebElement expectedResult2;
    LoginPage page;

    @BeforeMethod
    public void setUp(){
        report.setAuthor("Aliia");
        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void end(){
        report.logExpectedResult(expectedResult);

    }


    @Test(testName = "US 301: User Login Test", description = "Verify standard_user can login with right password")
    public void test01(){
        loginPage.usernameInputField.sendKeys("standard_user");
        loginPage.passwordInputField.sendKeys("secret_sauce");

        loginPage.loginBtn.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
        expectedResult = "https://www.saucedemo.com/inventory.html";
    }
    @Test(testName = "US 302: Locked out User Login Test", description = "When locked out user tries to login with right password I would like to see an error message 'Epic sadface: Sorry, this user has been locked out.'")
    public void test02(){
        loginPage.usernameInputField.sendKeys("locked_out_user");
        loginPage.passwordInputField.sendKeys("secret_sauce");

        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."));
        expectedResult = "Epic sadface: Sorry, this user has been locked out.";
    }

    @Test(testName = "US 303 - Problem User Login Test", description = "When problem_user logs in all items on homepage should display same images")
    public void test03(){
        loginPage.usernameInputField.sendKeys("problem_user");
        loginPage.passwordInputField.sendKeys("secret_sauce");

        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.image.isDisplayed());
//        expectedResult2 = loginPage.image;

    }

}
