package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

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


    public void Login (){
        usernameInputField.sendKeys("standard_user");
        passwordInputField.sendKeys("secret_sauce");
        loginBtn.click();
    }
}
