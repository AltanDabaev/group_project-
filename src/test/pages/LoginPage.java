package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;
import utils.ConfigReader;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseTest {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameInputField;

    @FindBy(id = "password")
    public WebElement passwordInputField;

    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(xpath = "//img[@src='/static/media/sl-404.168b1cce.jpg']")
    public WebElement image;


    public void Login (Method method){
        initializeDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigReader.readProperty("config.properties", "url"));
        report.createTestReport(driver,method);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
    }

}
