package tests._1positiveTests;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import tests.Base;
import tests.Constants;

public class _3UpdateBookByIdTest extends Base {
    @Test
    public void updateBookBuId(){

        JSONObject updateBook = new JSONObject();

        updateBook.put("author", Constants.UPDATE_AUTHOR);
        updateBook.put("title", Constants.UPDATE_TITLE);

        given()
                .header("Content-Type", "application/json")
                .body(updateBook.toJSONString())
        .when()
                .put("/"+Constants.INITIAL_ID)
        .then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .body("id", equalTo(Constants.INITIAL_ID))
                .body("author", equalTo(Constants.UPDATE_AUTHOR))
                .body("title", equalTo(Constants.UPDATE_TITLE));
    }
}