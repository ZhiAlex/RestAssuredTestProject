package tests._2negativeTests;

import org.testng.annotations.Test;
import tests.Base;
import tests.Constants;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class _3GetBookByIdTest extends Base {
    @Test
    public void getBookById(){

        when()
                .get("/"+ Constants.UNUSED_ID)
        .then()
                .statusCode(400)
                .body(equalTo("Book not found by id"));
    }
}