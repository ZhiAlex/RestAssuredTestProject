package tests._1positiveTests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import tests.Base;

public class _1GetBooksTest extends Base {
    @Test
    public void getBooks(){

        when()
                .get("/")
        .then()
                .statusCode(200);
    }
}