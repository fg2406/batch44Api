package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {


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


    //once gidip Postman da test ettik 123 olanin bilgilerine

    @Test
    public void  test05(){

      String url="https://jsonplaceholder.typicode.com/todos/123";

        Response response=given().when().get(url);
        response.prettyPrint();  // herseyi getirdi 123 teki


        //hepsini bu sekilde de yazabilir yada ikiye bolebiriz .boy den itibaren basina response.then. yaparak
        response.
                then().
                contentType(ContentType.JSON).      //bunun yerine "application/json”  yazilabilir
                statusCode(200).headers("Server", Matchers.equalTo("cloudflare")
                ,"Pragma","no-cache")
                .body("userId",Matchers.equalTo(7)
                        ,"title",Matchers.equalTo("esse et quis iste est earum aut impedit")
                        ,"completed",Matchers.equalTo(false));







    }

}
