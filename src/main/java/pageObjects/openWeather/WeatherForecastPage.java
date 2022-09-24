package pageObjects.openWeather;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

public class WeatherForecastPage extends CommonOps {
    @FindBy(how = How.XPATH, using = "//div[@id='weather-widget']/div[2]/div/div/div[2]/ul/li[3]")
    private WebElement humidityWeb;

    public WebElement get_humidityWeb() {
        return humidityWeb;
    }

}
