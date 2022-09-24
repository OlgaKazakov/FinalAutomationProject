package pageObjects.openWeather;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

public class MainPageOpenWeather extends CommonOps {
    @FindBy(how = How.CSS, using = "input[placeholder='Search city']")
    private WebElement txt_citySearch;

    public WebElement get_citySearch() {
        return txt_citySearch;
    }


    @FindBy(how = How.XPATH, using = "//div[@class='search-container']/ul/li")
    private WebElement cityRow;

    public WebElement get_cityRow() {
        return cityRow;
    }
}
