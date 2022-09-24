package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class WebForAPIFlow extends CommonOps {

    @Step("Entry to Forecast Weather in the City Page ")
    public static void entryForecastPage (){
        UIActions.updateText(mainOpenWeather.get_citySearch(), getData("city"));
        UIActions.insertKey(mainOpenWeather.get_citySearch(), Keys.RETURN);
        UIActions.click(mainOpenWeather.get_cityRow());
    }

    @Step ("Getting Humidity Value from Web")
    public static String getValue (){
        return UIActions.gettingTextFromElement(forecastOpenWeather.get_humidityWeb()).split("\\n")[1];
    }
}
