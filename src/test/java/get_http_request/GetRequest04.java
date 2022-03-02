package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {

/*
http://dummy.restapiexample.com/api/v1/employees  url'ine
 GET request'i yolladigimda gelen response'un
 status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
 */



    @Test
    public  void  test03(){


        String url="http://dummy.restapiexample.com/api/v1/employees";

        Response response=given().when().get(url);

        response.prettyPrint() ;

        response.then().contentType(ContentType.JSON).statusCode(200);


        response.then().assertThat().body("data", Matchers.hasSize(24)     //assertThat yazmasakta yapar ayni islemi

                ,"data.employee_name",Matchers.hasItem("Ashton Cox")    //icinde Ashton Cox varmi
                ,"data.employee_age",Matchers.hasItems(61,66,63));        // 3 data varmi sorgular,s takisina dikkat



    }




}
