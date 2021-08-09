import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03GetRequest {
    @Test
    public void googleMapTest(){
        //Specify base URI
        RestAssured.baseURI = "https://maps.googleapis.com";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object

        Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-0.242410,51.604435&radius=15000&type=bank&key=AIzaSyClL8bdmyVLdjEl3i8go5peT-TJgCQ-M6s"); //API_KEY taken from my google cloud account

        //Print response in console
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is :: " + responseBody);

        // validating headers
        String contentType = response.header("Content-Type"); //  capture details of content-type header
        System.out.println("Content-Type is :: " + contentType );
        Assert.assertEquals(contentType,"application/xml; charset=UTF-8");


        String contentEncoding = response.header("content-encoding"); //  capture details of content-type header
        System.out.println("Content-Encoding is :: " + contentEncoding );
        Assert.assertEquals(contentEncoding,"gzip");

    }
}
