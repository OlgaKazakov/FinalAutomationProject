package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
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
    }

    @Step("Post New Data To Server")
    public static void post (JSONObject params, String resource){
        request.header("Content-Type", "application/json");
        request.body(params.toJSONString());
        response = request.post(resource);
        response.prettyPrint();
    }

    @Step("Update Data in Server")
    public static void put (JSONObject params, String resource){
        request.header("Content-Type", "application/json");
        request.body(params.toJSONString());
        response = request.put(resource);
        response.prettyPrint();
    }

    @Step("Delete Data in Server")
    public static void delete (String resource){
        response = request.delete(resource);
    }
}
