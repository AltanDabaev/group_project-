package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver){PageFactory.initElements(driver, this);
    }
    @FindBy(id = "react-burger-menu-btn")
    public WebElement navMenuButton;

    @FindBy(id = "about_sidebar_link")
    public WebElement about;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItems;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logout;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState;

    @FindBy(className = "footer_copy")
    public WebElement footer;

    @FindBy(xpath = "//ul/li")
    public List<WebElement> socialMediaButtons;

    @FindBy(className = "product_sort_container")
    public WebElement filterButton;

    @FindBy(tagName = "option")
    public List <WebElement> filterOptions;

}
