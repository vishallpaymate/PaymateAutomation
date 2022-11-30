package pageFactory;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class restAssured {

    public static void getResponseBody(){
        given().header("apikey","8BCE4691-D1C6-40E6-B8E3-4CB7A17B5226")
                .when().post("https://dev.paymate.in/Beta/VisaBaaSApi/v1/BPSPList").then().log().body();
    }

    public static void getResponseStatus(){
        int statusCode= given().header("apikey","8BCE4691-D1C6-40E6-B8E3-4CB7A17B5226")
                .when().get("https://dev.paymate.in/Beta/VisaBaaSApi/v1/BPSPList").getStatusCode();
        System.out.println("The response status is "+statusCode);
        given().when().get("https://dev.paymate.in/Beta/VisaBaaSApi/v1/BPSPList").then().assertThat().statusCode(200);
    }

    public static void main(String args[]) {
        getResponseBody();
        getResponseStatus();
        }

}
