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

    @Step ("Business Flow: Get Student Data")
    public static String getStudentData(String jPath) {
        response = APIActions.get("student/list");
        return APIActions.extractFromJson(response, jPath);
    }

    @Step ("Business Flow: Create New Student - API")
    public static void postStudent(String firstname, String lastname, String email, String programme){
        params.put("firstName", firstname);
        params.put("lastName", lastname);
        params.put("email", email);
        params.put("programme", programme);

        APIActions.post(params, "/student");
        System.out.println(response.getBody());
    }

    @Step ("Business Flow: Create New Student - API")
    public static void updateStudent(String firstname, String lastname, String email, String programme, String id){
        params.put("firstName", firstname);
        params.put("lastName", lastname);
        params.put("email", email);
        params.put("programme", programme);

        APIActions.put(params, "/student/" + id);
        System.out.println(response.getBody());
    }
}
