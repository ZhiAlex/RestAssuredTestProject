package tests;

import org.testng.annotations.BeforeTest;

import java.io.File;

import static io.restassured.RestAssured.baseURI;

public class Base {

    @BeforeTest
    public void getBaseUrl(){
        baseURI = "http://localhost:3000/books";
    }
}
