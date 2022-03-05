package get_http_request.day7;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest16 extends JsonPlaceHolderBaseUrl {

       /*
   https://jsonplaceholder.typicode.com/todos/7

   {
   "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false
}
    */

   @Test
   public void test16(){

      //1) URL OLUSTURMA
      spec04.pathParams("bir", "todos", "iki", 7);

      //2) EXPECTED(BEKLENEN) DATA OLUSTUR

      Map<String, Object> expectedData = new HashMap<>();
      expectedData.put("userId", 1);
      expectedData.put("id", 7);
      expectedData.put("title", "illo expedita consequatur quia in");
      expectedData.put("completed", false);

      System.out.println("EXPECTED DATA: " + expectedData);
      //EXPECTED DATA: {id=7, completed=false, title=illo expedita consequatur quia in, userId=1}

      //3) REQUEST VE RESPONSE

      //https://jsonplaceholder.typicode.com
      Response response = given().spec(spec04).when().get("/{bir}/{iki}");
      //"/{bir}/{iki}" -> adrese bunu ekle /todos/7
      //https://jsonplaceholder.typicode.com/todos/7

      response.prettyPrint();

     /* {
         "userId": 1,
              "id": 7,
              "title": "illo expedita consequatur quia in",
              "completed": false
      }  */


      //excepted ile yukardaki datayi kiyaslamak istiyoruz ama ikiside farkli bu yuzden donusturecegiz



      //DATAYI JSON'DAN -> JAVA'YA De-Serialization
      //DATAYI JAVA'DAN -> JSON'A Serialization


      ///!!!!Donusturuyoruz
      Map<String, Object> actualData = response.as(HashMap.class);    //De-Serialization

      System.out.println("ACTUAL DATA: " + actualData);

//Actual Data :{id=7, completed=false, title=illo expedita consequatur quia in, userId=1}

      Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
      Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
      Assert.assertEquals(expectedData.get("title"), actualData.get("title"));
      Assert.assertEquals(expectedData.get("completed"), actualData.get("completed"));


   }




}


//!! datayi java da Json'a donusturme islemine de-Serialization denir
//tam tersi isleme yani datayi Json' dan Java yani Map'a Serialization denir
//datayi javadan>>Json'a donusturme isimi= de-serialization
//datayi Jsondan>>Java'ya donusturme isimi= serialization
//expected ve actual datalarin ayni formatta karsilastirilmasi icin yapilan donusturme islemleri
//bu donusumler icin Pom'a birseyler ekledik'


/// !!DONUSTURUYORUZ!!!!


//!!! simdi ecpected data ile burdaki sonucu kiyaslayamam cunku sonuclar ayni degil
// bu yuzden diger datayi java ya donusturecegiz asagida
