package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    public ShoppingCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
