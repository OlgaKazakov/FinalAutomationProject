package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class tempAPIDummy {
    public RequestSpecification httpRequest;
    public Response response;
    String url = "https://dummy.restapiexample.com";
    JSONObject requestParams;

    @BeforeClass
    public void start(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        //httpRequest.header("Content-Type", "application/json");
    }

    @Test
    public void test01API_printUsersListPage1() {
        // GET request
        //response = httpRequest.get("/api/users?page=1");
        //response = httpRequest.get("/api/v1/employees");
        response = httpRequest.get("/api/v1/employee/21");
        response.prettyPrint();
        //Verification
    }

    @Test
    public void test02_addingUser(){
        // POST request
        requestParams = new JSONObject();
        //"id":1,"employee_name":"Tiger Nixon","employee_salary":320800,"employee_age":61,"profile_image":""
        //https://dummy.restapiexample.com/api/v1/create
        requestParams.put("employee_name", "John Jonson");
        requestParams.put("employee_salary", "212121");
        requestParams.put("employee_age", "21");
        requestParams.put("profile_image", "john");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.post("/api/v1/create");
        response.prettyPrint();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test03API_changesIn21() {
        // PUT request
        requestParams.put("employee_name", "Jenette");
        requestParams.put("employee_salary", "345000");
        requestParams.put("employee_age", "23");
        requestParams.put("profile_image", "");
        response = httpRequest.put("/api/v1/employee/21");
        //response = httpRequest.get("/api/v1/employees");
        response.prettyPrint();
        //Verification

    }


    // "id": 21,
    //        "employee_name": "Jenette Caldwell",
    //        "employee_salary": 345000,
    //        "employee_age": 30,
    //        "profile_image": ""

    @Test
    public void test04_deletingUser(){
        // DELETE request
        response = httpRequest.get("/api/v1/employee/1367");
        response.prettyPrint();
        response = httpRequest.delete("/api/v1/employee/1367");
        assertEquals(response.getStatusCode(), 204);
    }
}
