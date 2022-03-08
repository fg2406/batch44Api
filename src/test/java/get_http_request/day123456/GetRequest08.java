package get_http_request.day123456;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends DummyBaseUrl {

    /*
   http://dummy.restapiexample.com/api/v1/employees url'inde bulunan

  1) Butun calisanlarin isimlerini consola yazdıralim
  2) 3. calisan kisinin ismini konsola yazdıralim
  3) Ilk 5 calisanin adini konsola yazdiralim
  4) En son calisanin adini konsola yazdiralim
*/

    @Test
    public  void  test08(){

      spec02.pathParams("first", "restApi","second","v1","third","employees");

        Response response = given().spec(spec02).when().get("/{first}/{second}/{third}");
        // "/{first}/{second}/{third}"  == > /api/v1/employees


        response.prettyPrint();

        //1)  Butun calisanlarin isimlerini consola yazdiralim

        JsonPath json=response.jsonPath();
        System.out.println(json.getString("data.employee_name"));

        //2) 3.calisanin ismini konsola yazdiralim
        System.out.println(json.getString("data[2].employee_name"));

        //3) ilk 5 calisanin adini konsola yazdiralim
          //1.yol
           for (int i = 0; i < 5; i++) {
            System.out.println(i+1+". calisan : "+json.getString("data[" + i + "].employee_name"));

           }

        //2.yol
        System.out.println(json.getString("data.employee_name[0,1,2,3,4]"));

         //en son calisanin ismini yazdirin

        //1.yol
        System.out.println(json.getString("data[-1].employee_name"));
       //1.yol 2.sekil
        System.out.println(json.getString("data.employee_name[-1]"));


        //2.yol
        json.getList("data.employee_name").stream().limit(4).forEach(t-> System.out.println(t));
    }



}
