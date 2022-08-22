package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

public class CartPage extends CommonOps {

    @FindBy (how = How.CLASS_NAME, using = "inventory_item_name")
    private WebElement inCart;

    public WebElement getInCart() {
        return inCart;
    }

    @FindBy (how = How.ID, using = "checkout")
    private WebElement btn_checkout;

    public WebElement get_btnCheckout() {
        return btn_checkout;
    }

}
