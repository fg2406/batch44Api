package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetReqpuesrtMatcherClass06 {

   /* https://restful-booker.herokuapp.com/booking/5 url’ine
    accept type’i “application/json” olan GET request’i yolladigimda
    gelen response’un
    status kodunun 200
    ve content type’inin “application/json”
    ve firstname’in “Jim”
    ve totalprice’in 600
    ve checkin date’in 2015-06-12"oldugunu test edin   */

    @Test
    public  void  test01(){

     String url="https://restful-booker.herokuapp.com/booking/5";

        Response response=given().when().get(url);
        response.prettyPrint();

        response.then().assertThat().contentType(ContentType.JSON).statusCode(200); // ContentType.JSON yerine  application/json yazilabilir

        response.then().body("firstname", Matchers.equalTo("Susan")
        ,"totelprice",Matchers.equalTo(958)
        ,"bookingdates.checkin",Matchers.equalTo("2018-12-06"));    //bady icinde bazen bady oluyor,bady icine . ile giriliyor



    }



}
