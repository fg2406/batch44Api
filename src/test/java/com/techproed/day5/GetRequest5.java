package com.techproed.day5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest5 {

  /*  https://restful-booker.herokuapp.com/booking/5 url'ine

   accept type'i "application/json" olan GET resquest'i yolladigimda
   gelen response'un
   status kodu 200
   content type'inin "application/json"
    !!!sonra body geliyor!!!!
   ve firstname "Jim"
   ve totalprice 600
   ve lastname "Jones"
   ve checkin date'in 2015-06-12
        */


   @Test
    public  void  test(){


       //1)URL OLUSTURMA
     String url="https://restful-booker.herokuapp.com/booking/5";

     //2)expectedData


     //3)Resquest ve responce

       Response response=given().accept("application/json").when().get(url);
       response.prettyPrint();

     //4)dogrulama

      response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
           body("firstname", equalTo("Sally")
                   ,"lastname",equalTo("Wilson")
                   ,"totalprice",equalTo(705)
                   ,"bookingdates.checkin",equalTo("2017-08-16"));

    //surekli baska data geliyor bu yuzden faild oldu

   }



}
