import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05ValidatePartialJSONResponse {

    @Test
    public void validatePartialJSONResponse(){

        RestAssured.baseURI = "http://localhost:3000";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object

        Response response = httpRequest.request(Method.GET,"/posts?id=2"); //API_KEY taken from my google cloud account

        //Print response in console
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is :: " + responseBody);

        Assert.assertEquals(responseBody.contains("Nikunj"),true);

    }
}
