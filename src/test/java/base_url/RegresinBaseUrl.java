package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.BeforeClass;

public class RegresinBaseUrl {
   //bunun ile onceki pack deki kullanimi aynidir,bu sekilde de kullanilir bunu da yapiyoruz
  public RequestSpecification spec01;

   @Before
   public void setUp(){

       spec01=new RequestSpecBuilder().setBaseUri("https://regres.in").build();      //builder insa et demek
   }



}
