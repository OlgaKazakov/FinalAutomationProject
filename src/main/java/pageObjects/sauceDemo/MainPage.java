package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

import java.util.List;

public class MainPage extends CommonOps {

    @FindBy (how = How.XPATH, using = "//span [@class ='title']")
    private WebElement title_MainPage;
    public WebElement getTitleMainPage () {
        return title_MainPage;
    }

    @FindBy (how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    private WebElement btn_AddBackpack;
    public WebElement getBtn_AddBackpack () {
        return btn_AddBackpack;
    }

    @FindBy (how = How.ID, using = "shopping_cart_container")
    private WebElement btn_CartContainer;
    public WebElement getBtn_CartContainer () {
        return btn_CartContainer;
    }

    @FindBy (how = How.XPATH, using = "//div [@class='inventory_item']")
    private List <WebElement> products;
    public List<WebElement> getProductsList() {
        return products;
    }

}
