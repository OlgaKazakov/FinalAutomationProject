package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class tempAPIReqres {
    public RequestSpecification httpRequest;
    public Response response;
    String url = "https://reqres.in/";
    //String url = "https://dummy.restapiexample.com/";

    @BeforeClass
    public void start(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        //httpRequest.header("Content-Type", "application/json");
    }

    @Test
    public void test01API_printUsersListPage1() {
        // GET request
        for (int i = 1; i<4; i++) {
            System.out.println("For Page " +i);
            response = httpRequest.get("/api/users?page=i");
            response.prettyPrint();
            //Verification
        }
    }

    @Test
    public void test02_addingUser(){
        // POST request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Richard3");
        requestParams.put("job", "King");
        //requestParams.put("last_name", "Third");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.post("/api/users");
        response = httpRequest.get("/api/users?id=13");
        response.prettyPrint();
        //assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void test03API_printUsersListPage1() {
        // GET request
        response = httpRequest.get("/api/users?page=3");
        response.prettyPrint();
        //Verification

    }

    @Test
    public void test04_deletingUser(){
        // DELETE request
        response = httpRequest.delete("/api/users/13");
        assertEquals(response.getStatusCode(), 204);
    }


}
