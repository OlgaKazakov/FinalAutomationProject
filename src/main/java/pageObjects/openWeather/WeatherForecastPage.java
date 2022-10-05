package pageObjects.openWeather;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

public class WeatherForecastPage extends CommonOps {
    @FindBy(how = How.XPATH, using = "//ul[@class='weather-items text-container orange-side standard-padding']/li[3]")
    private WebElement humidityWeb;

    public WebElement get_humidityWeb() {
        return humidityWeb;
    }

}
