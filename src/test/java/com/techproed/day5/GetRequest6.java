package com.techproed.day5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest6 {

/*
http://dummy.restapiexample.com/api/v1/employees  url'ine
 GET request'i yolladigimda gelen response'un
 status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
 */


    @Test
    public void test01(){
      //url olustur
     String url="http://dummy.restapiexample.com/api/v1/employees";

     //resquest und response
        Response response=given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

     //dogrulama matchers class ile
       /* status kodunun 200 ve content type'inin "application/json"
        ve employees sayisinin 24
        ve employee'lerden birinin "Ashton Cox"
        ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.  */
       response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id",hasSize(24)
                        ,"data.employee_name",hasItem("Ashton Cox")
                        ,"data.employee_age",hasItems(21,61,23));

     //employee_age --> bu ifadelere jsonpath denir

    //body("data.id",Matchers.hasSize("value"); key olarak verilen degisken'in sayisinin value'ye esit olup olmadgini kontrol eder
    //body("data.employee_name",Matchers.hasItem("value"));key olarak verilen degiskenin aldigi degerlerin icinde value varmi diye kontrol eder
    //value fazla ise hasItems("value,value..") seklinde virgul ile yazilabilir





    }







}
