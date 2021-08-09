import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06ValidateEntireJSONResponse {

    @Test
     public void validateEntireJSONResponse(){

        RestAssured.baseURI = "http://localhost:3000";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object

        Response response = httpRequest.request(Method.GET,"/posts?id=2"); //API_KEY taken from my google cloud account

        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.get("id"));
        System.out.println(jsonPath.get("title"));
        System.out.println(jsonPath.get("author"));



        final String author = response.jsonPath().getString("author[0]");

       // Assert.assertEquals(jsonPath.get("author"),"Nikunj"); //this will return value as [Nikunj] hence it doesn't match with actual value
        Assert.assertEquals(author,"Nikunj");

    }
}
