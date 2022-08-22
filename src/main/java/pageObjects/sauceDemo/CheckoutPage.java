package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

public class CheckoutPage extends CommonOps {
    @FindBy (how = How.ID, using = "first-name")
    private WebElement txt_firstName;

    public WebElement getTxt_firstName() {
        return txt_firstName;
    }

    @FindBy (how = How.ID, using = "last-name")
    private WebElement txt_lastName;

    public WebElement getTxt_lastName() {
        return txt_lastName;
    }

    @FindBy (how = How.ID, using = "postal-code")
    private WebElement txt_postalCode;

    public WebElement getTxt_postalCode() {
        return txt_postalCode;
    }

    @FindBy (how = How.ID, using = "continue")
    private WebElement btn_continue;

    public WebElement getBtn_continue() {
        return btn_continue;
    }
}
