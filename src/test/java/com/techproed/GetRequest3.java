package com.techproed;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest3 {


   /*https://restful-booker.herokuapp.com/booking/1001 url'ine
     accept type'i "application/json"olan GET requesrt'i yolladigimda
    gelen response'un(sonuc)
    statuscode 404
    ve Response body'sinin "Bot Found"icerdigini
    ve Response body'sinin "Api"icermedigini test edin

    */

   @Test
    public  void  test01(){

      //1)Url olusturma
       String url="https://restful-booker.herokuapp.com/booking/1001";

       //2)excepted datayi olustur(body gerekmedigi icin olusturmuyoruz)

       // 3)resquest(istek )gonder

      Response response=given().
              accept("application/json").
              when().
              get(url);   //burda test yesil olabilir ama bu dogrulandigini gostermez
       //dogrulama assert ler ile olur

       //4)Dogrulama
        // statuscode 404
       // ve Response body'sinin "Not Found"icerdigini
       //ve Response body'sinin "Api"icermedigini test edin
       response.then().assertThat().statusCode(404);
       Assert.assertTrue(response.asString().contains("Not Found"));
       Assert.assertFalse(response.asString().contains("Api"));
       //asString methodu ile Stringe cevirip String methodlari kullanilabilir


   }





}
