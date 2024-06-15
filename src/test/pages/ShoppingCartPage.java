package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    public ShoppingCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    public WebElement addCard;

    @FindBy(id="shopping_cart_container")
    public  WebElement shopCardConteiner;

    @FindBy(xpath = "//div[@class=\"cart_item\"]")
    public WebElement item;

    @FindBy(xpath = "//button[@class=\"btn btn_secondary btn_small cart_button\"]")
    public WebElement removeBtn;

}
