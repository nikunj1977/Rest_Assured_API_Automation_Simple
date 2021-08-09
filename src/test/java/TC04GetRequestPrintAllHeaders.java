import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC04GetRequestPrintAllHeaders {

    @Test
    public void GetWeahtherDetails(){
        //Specify base URI
        RestAssured.baseURI = "https://maps.googleapis.com";
        //RestAssured.baseURI = "https://qa-fandangoloyalty.spika.com";
        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        RestAssured.given().headers("Authorization","Token token=a896b8ae90cd682b9de85a88fbe4300f");

        //Response object

        Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-0.242410,51.604435&radius=15000&type=bank&key=AIzaSyClL8bdmyVLdjEl3i8go5peT-TJgCQ-M6s"); //API_KEY taken from my google cloud account
        //Response response = httpRequest.request(Method.GET,"/loyaltyApi/site/mcwe/users/FAN388_001/ledger?skip=0&limit=40"); //API_KEY taken from my google cloud account
        //Print response in console
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is :: " + responseBody);

        Headers allHeaders = response.headers(); // capture all the headers from the response

        for(Header header:allHeaders){

            System.out.println(header.getName()+ " " + header.getValue());
        }
    }
}
