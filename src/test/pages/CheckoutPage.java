package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="shopping_cart_container")
    public  WebElement shopCardConteiner;

    @FindBy(id = "checkout")
    public WebElement checkPage;


    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;
}
