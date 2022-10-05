package pageObjects.openWeather;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageOpenWeather{
    @FindBy(how = How.CSS, using = "input[placeholder='Search city']")
    private WebElement txt_citySearch;

    public WebElement get_citySearch() {
        return txt_citySearch;
    }


    @FindBy(how = How.XPATH, using = "//div[@class='search-container']/ul/li[1]")
    private WebElement cityRow;

    public WebElement get_cityRow() {
        return cityRow;
    }
}
