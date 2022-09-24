package sanity;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import extensions.Verifications;
import workflows.WebForAPIFlow;
import utilities.CommonOps;
import workflows.APIFlows;

@Listeners (utilities.Listeners.class)
public class OpenWeatherAPIWeb extends CommonOps {

    @Test(description = "Test01 - Verifies a country Using API")
    @Description("This test verifies a country Using API")
    public void test01_verifyCountry() {
        response = APIFlows.getResponseFromAPI();
        Verifications.verifyAPIResponseContainsWord(response, "IL");
    }

    @Test(description = "Test02 - Verifies values of Humidity from API and from Web")
    @Description("This test verifies values of Humidity from API and from Web")
    public void test02_verifyValuesHumidityFromAPIAndWeb() {
        response = APIFlows.getResponseFromAPI();
        humidityAPI = APIFlows.getHumidityFromAPI(response);

        WebForAPIFlow.entryForecastPage();
        humidityWeb = WebForAPIFlow.getValue();

        Verifications.verifyText(humidityAPI+"%", humidityWeb);
    }

}
