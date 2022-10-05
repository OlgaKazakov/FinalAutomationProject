package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChOverviewPage {
    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
    private WebElement inventName;

    public WebElement get_inventName() {
        return inventName;
    }

    @FindBy(how = How.CLASS_NAME, using = "summary_total_label")
    private WebElement totalSum;

    public WebElement get_totalSum() {
        return totalSum;
    }
}
