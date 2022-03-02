package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetRequest03 {
    /*
        https://restful-booker.herokuapp.com/booking/7 url'ine
    GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    ve content type'inin "application/json"
    ve firstname'in "Sally"
    ve lastname'in "Ericsson"
    ve checkin date'in 2018-10-07"
    ve checkout date'in 2020-09-30 oldugunu test edin
         */
    @Test
    public  void  test03(){

        String url ="https://restful-booker.herokuapp.com/booking/7";
        Response response=given().when().get(url);
        response.prettyPrint();  //7 de olan tum bilgileri getirir


        // bu iki yontemde ayni,ikiside olur

        //response.then().contentType("application/json").statusCode(200);

        response.then().contentType(ContentType.JSON).statusCode(200); //dogrulama yaptik then ile


        response.then().body("firstname", equalTo("Eric")

                   ,"lastname",equalTo("Smith")
                    ,"checkin",equalTo("2016-10-11")
                ,"checkout",equalTo("2019-07-14"));              ;





    }







}
