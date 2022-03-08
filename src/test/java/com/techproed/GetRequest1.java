package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest1 {
    //juNIt VE REST ASSERT dependency yukledik pom a

      /*https://restful-booker.herokuapp.com/booking/3 adresine bir request(istek) gonderildiginde
    fonecek cevap(response) icin

    HTTP status kodunun 200
    Concent Type'in Json
    ve status Line in HTTP/1.1.200  ok
    oldugunu test edin    */

    @Test
            public  void  test01() {


        //1-api testi yaparken ilk olarak ulr(endpoint) belirlenmeli

        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2-beklenen sonuc(expected result) olusturulur,bazen map,bazen java list seklinde olur bundan dolayi cok kullanacaz
        //bu case de be3nde bady dogrulanmasi istenmedigi icin simdilik beklenen sonuc olusturmuyoruz


        //3-resquest gonderilir(yani istek)
        Response response=given().
                accept("application/json").
                when().
                get(url);
        /*url istek olarak gonderdik,Url ile gelen
          butun bilgileri (body,headers,status vs. tumunu tutar Response)

          given()--> import static io.restassured.RestAssured.given;    olacak */

        //4.actual result olustur ,simidilik  bunu yapmiyoruz body ile ilgili birsey istenmedigi icin


        //5-dogrulama yap yani Assertion

         // response.prettyPrint();  //butun herseyi getirr,gormek icin yazdik yazmasakta olur
        //istenen degerlerin actual degerlerini yazdik
         //HTTP status kodunun 200
        System.out.println("Status code :"+response.getStatusCode());   //response den gelen Status code :200
        //    Concent Type'in Json
        System.out.println("content type :"+response.getContentType()); //response den gelen content type :application/json; charset=utf-8
        //    ve status Line in HTTP/1.1.200  ok   oldugunu test edin
        System.out.println("status line :"+response.getStatusLine());   //response den gelen status line :HTTP/1.1 200 OK

        //extta birseylerde test edebiliriz
        System.out.println(response.getHeaders()); //header deki herseyi getirir



        /*
        1.yol dogrulama icin
        //expected kismi bize task olarak verilen degerdir,actual kismi ise response den donen degerdir
        //status kodu in deger dondurur
        Assert.assertEquals(200,response.statusCode());

        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());  */

        //2.yol
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");


    }

}
