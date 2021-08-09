import com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01GetRequest {

    @Test
    public void getAuthorDetails(){
        //Specify base URI
        RestAssured.baseURI = "http://localhost:3000";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object

        Response response = httpRequest.request(Method.GET,"/posts");//?id=2

        //Print response
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is :: " + responseBody);

        // Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is ::" + statusCode);

        //Status code Asertion
        Assert.assertEquals(statusCode,200);

        //Status line verification
        String statusLine = response.statusLine();
        System.out.println("Status line is :: " + statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

    }





}
