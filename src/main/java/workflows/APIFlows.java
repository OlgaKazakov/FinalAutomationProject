package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
