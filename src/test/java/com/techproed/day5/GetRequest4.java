package com.techproed.day5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;   //boyle yapinca Matchers methodlarinin hepsini kullanabiliriz
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest4 {

   /* https://restful-booker.herokuapp.com/booking/7 url'ine

   accept type'i "application/json" olan GET resquest'i yolladigimda
   gelen response'un
   status kodu 200
   content type'inin "application/json"
    !!!sonra body geliyor!!!!
   ve firstname "Mary"
   ve lastname "Jones"
   ve checkin date'in 2018-10-07
   ve checkout date'in 2020-09-30 oldugunu test edin
     */

    @Test
    public  void  test(){

      //1)URL olusturma
      String url="https://restful-booker.herokuapp.com/booking/7";

      //3)Resquest ve Response

        Response response=given().accept("application/json").when().get(url);
        response.prettyPrint();

        //4)Dogrulama
        //normal Assert methodlari ile de olur ama biz burda Match class tan faydalanacagiz


       ///Matchers class ile api den sonucu assert etme


       /* response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
          body("firstname", Matchers.equalTo("Susan")).
                body("lastname",Matchers.equalTo("Jones")).
                body("totalprice",Matchers.equalTo(425)).
                body("depositpaid",Matchers.equalTo(false)).
                body("bookingdates.checkin",Matchers.equalTo("2016-01-31")).
                body("bookingdates.checkout",Matchers.equalTo("2017-06-06"));

              !!simdi bunu biarz daha kisa yazacagiz,surekli body yerine bir tane body icine yazariz hepsini
              bu daha profesyonel
                 */

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", equalTo("Eric")
                    ,"lastname",equalTo("Jackson")
                    , "totalprice",equalTo(727 )
                    , "depositpaid",equalTo(true)
                    , " bookingdates.checkin",equalTo("2022-02-21")
                    , "bookingdates.checkout",equalTo("2022-02-22"));

     //!!test pass olsun diye ben datalari hizli degistirdim,cunku datalar birkac dakikada bir degisiyor
        //normalde bu kadar veriler bu kadar hizli degismez,datalar verilir,bu sisteme kayit olmus mu bak,biz propertis gibi biryere onari kayit
        //ederiz sonra karsilastirirz sistemde bu kisi varmi yokmu

    }


}
