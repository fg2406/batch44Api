package get_http_request;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {


    @Test
    public void test01(){
     //url burda olmasi pek tercih edilmez bu yuzden baseurl olusturp oraya atadik
       String url="https://restful-booker.herokuapp.com/booking";
        Response response=given().when().get(url);
         //response.prettyPrint(); url sonuna 2 yazdik tum bilgiler icin bunu yazdik

        System.out.println("Status Code :"+ response.statusCode());  // bu 200 ise saglikli demek,aranan hep 200 olmali
        System.out.println("Content Type :"+ response.contentType());
        System.out.println("Test Zamani :"+ response.time());


        Assert.assertEquals(200,response.statusCode());   //200 e dikkat tirnak icine alirsan String algilar in tolmali

        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8");

    }



}
