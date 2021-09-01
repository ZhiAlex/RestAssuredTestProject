package tests._1positiveTests;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import tests.Base;
import tests.Constants;

public class _4GetBookByIdTest extends Base {
    @Test
    public void getBookById(){

        when()
                .get("/"+Constants.INITIAL_ID)
        .then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .body("id", equalTo(Constants.INITIAL_ID))
                .body("author", equalTo(Constants.UPDATE_AUTHOR))
                .body("title", equalTo(Constants.UPDATE_TITLE));
    }
}