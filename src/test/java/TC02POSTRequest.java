import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02POSTRequest {
    @Test
    public void postAuthorRequest() throws JSONException {

        //Specify base URI
        RestAssured.baseURI = "http://localhost:3000";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Body Payload
        //JSONObject requestParams = new JSONObject();
        JSONObject requestParams = new JSONObject();

        requestParams.put("author","Vishal");
        requestParams.put("id",6);
        requestParams.put("title","Jenkins New Editions");

        //Pass header
        httpRequest.header("Content-Type","application/json");

        //To convert body into JSON format
        httpRequest.body(requestParams.toJSONString());

        //Response object
        Response response = httpRequest.request(Method.POST,"/posts");

        //Print response in console

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is ::" + responseBody);

        //Status code validation
        int statusCode = response.statusCode();
        System.out.println("Status Code is ::" + statusCode);
        Assert.assertEquals(statusCode,201);

        //Success code validation
        /*String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(statusCode,"OPERATION_SUCCESS");*/


    }
}
