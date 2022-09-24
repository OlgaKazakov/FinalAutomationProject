package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;

public class APIFlows extends CommonOps {

    @Step ("Business Flow: Get Response From API")
    public static Response getResponseFromAPI(){
        return APIActions.get("?q=" + getData("city") + "&appid=" + getData("key") + "&units=" + getData("units"));
    }

    @Step ("Business Flow: Get Humidity Value From API")
    public static String getHumidityFromAPI(Response response){
        return APIActions.extractFromJson(response, getData("pathHumidity"));
    }

}
