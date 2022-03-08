package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest2 {

   /*https://restful-booker.herokuapp.com/booking url'ine
   accept type'i "application/json"olan GET requesrt'i yolladigimda
    gelen response'un(sonuc)
    status 200
    concent type'inin "application/json" oldugunu test edin*/

    //!! header pek degismedigi icin dinamik yapamaya gerek duyulmaz
    //!!! ama body degistigi icin dinamik yapariz

    @Test

    public void  test01(){
        //1)URL OLUSTURMA
       String url="https://restful-booker.herokuapp.com/booking" ;
       //2)excepted datayi olustur(body gerekmedigi icin olusturmuyoruz)
        // 3)resquest(istek )gonder

        Response response=given().accept("application/json").when().get(url);
        response.prettyPrint();


      //status 200
        //concent type'inin "application/json" oldugunu test edin
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);



    }


}
