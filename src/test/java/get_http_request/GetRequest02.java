package get_http_request;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetRequest02 {


   @Test
    public  void  test02(){

     String Url="https://reqres.in/api/users";

       Response response=given().when().get(Url);
       response.prettyPrint();            //responnse deki body getirir
       response.prettyPeek();         //response deki herseyi getirir
       response.then().log().all();  //response deki herseyi getirir

      //Headers deki bilgileri test ettik
       response.
               then().
               assertThat().
               statusCode(200).
               contentType("application/json; charset=utf-8")
               .statusLine("HTTP/1.1 200 OK");



        //Matchers class i kullanarak yaptik body icini
      //Body deki 1. siradaki bilgileri test ettik,index olarak calisir,0 dan baslar
       // key-value iliskisi seklinde yazilir
       response.then().body("data[0].first_name", equalTo("George")
               ,"data[0].last_name", equalTo("Bluth")
               ,"data[0].email", equalTo("gerorge.bluth@reqres.in"));   //key value


       //response.then() --> dogru la demek,then ile

        response.then().body("data[1].id",equalTo(2)
                ,"data[1].email",equalTo("janet.weaver@reqres.in")
                ,"data[1].first_name",equalTo("Janet")
                ,"data[1].last_name",equalTo("Weaver")
                ,"data[1].avatar",equalTo("https://reqres.in/img/faces/2-image.jpg"));







   }



}
