package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;

public class APIActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String paramValues){
        response = request.get(paramValues);
        response.prettyPrint();
        return response;
    }

    @Step("Extract Value From JSON Format")
    public static String extractFromJson(Response response, String path) {
        jp = response.jsonPath();
        return jp.getString(path);
        //return jp.get(path).toString; - from Yoni
    }
}
