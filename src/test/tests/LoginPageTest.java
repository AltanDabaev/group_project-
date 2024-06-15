package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest{
    LoginPage page;

    @BeforeMethod
    public void setUp(){
        page = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Test(testName = "US 301: Verify standard_user can login with right password")
    public void test01(){
        page.usernameInputField.sendKeys("standard_user");
        page.passwordInputField.sendKeys("secret_sauce");

        page.loginBtn.click();


        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
    }
    @Test(testName = "US 302: When locked out user tries to login with right password I would like to see an error message 'Epic sadface: Sorry, this user has been locked out.'")
    public void test02(){
        page.usernameInputField.sendKeys("locked_out_user");
        page.passwordInputField.sendKeys("secret_sauce");

        page.loginBtn.click();

        Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).getText().contains("Epic sadface: Sorry, this user has been locked out."));

    }
    @Test(testName = "US 303 - When problem_user logs in all items on homepage should display same images")
    public void test03(){
        page.usernameInputField.sendKeys("problem_user");
        page.passwordInputField.sendKeys("secret_sauce");

        page.loginBtn.click();

        Assert.assertTrue(page.image.isDisplayed());

    }

}
