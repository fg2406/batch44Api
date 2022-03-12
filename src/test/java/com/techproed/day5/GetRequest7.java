package com.techproed.day5;

import base_url.JsonPlaceHolderUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest7 extends JsonPlaceHolderUrl {


    //bu class ta biraz daha bazi seyleri dinamik yapacaz ,mesela url deki path param kisimlari degisiklik gosterebiliyor,temel
    // URL degismiyorsa--> yani bu kisim --> https://jsonplaceholder.typicode.com
    //sonraki kisim parth param kisim degisebilir o kisma parametre 1,parametre 2 desek ,dinamik olur
    //bu yuzden temel url kismi biz bir package olusturup oraya koyup extends yaparak cagirabiliriz

/*
    https://jsonplaceholder.typicode.com/todos/123 url’ine
    accept type’i “application/json” olan GET request’i yolladigimda
    gelen response’un
    status kodunun 200
    ve content type’inin “application/json”
    ve Headers’daki “Server” in “cloudflare”
    ve response body’deki “userId”’nin 7
    ve “title” in “esse et quis iste est earum aut impedit”
    ve “completed” bolumunun false oldugunu test edin    */


   @Test
    public  void  test01(){
     //Base_url de ki class'a extends yaptik ve ordan url i aldik
      spec04.pathParams("parametre1","todos","parametre2",123); //parametre1 yerine name de yazabiliriz yani todos da yazabiliriz
           //ama karisiklik olmasin diye biz parametre1.. gibi isimlendirdik

      //resquest ve response olusturduk/ b

       Response response=given().
               accept(ContentType.JSON).
               spec(spec04).
               when().get("/{parametre1}/{parametre2}"); //

       response.prettyPrint();

       //Dogrulama yapariz

       //status kodunun 200
       //       ve content type’inin “application/json”
       //       ve Headers’daki “Server” in “cloudflare”
       //       ve response body’deki “userId”’nin 7
       //       ve “title” in “esse et quis iste est earum aut impedit”
       //       ve “completed” bolumunun false oldugunu test edin

     response.
             then().
             assertThat().
             statusCode(200).
             contentType("application/json").
             header("Server",equalTo("cloudflare")).
             body("userId",equalTo(7),
                     "title",equalTo("esse et quis iste est earum aut impedit"),"completed",equalTo(false));



   }


}
