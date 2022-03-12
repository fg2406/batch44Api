package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderUrl {


   protected RequestSpecification spec04;


   @Before
    public void  setUp(){

     spec04=new RequestSpecBuilder().
             setBaseUri("https://jsonplaceholder.typicode.com").
             build();             //verdigim url insa et demek,build olamadan sonda calismaz


   }





}
