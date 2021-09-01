package tests._2negativeTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import tests.Base;
import tests.Constants;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class _2UpdateBookByIdTest extends Base {
    @Test
    public void UpdateByNonExistentId(){

        JSONObject updateBook = new JSONObject();

        updateBook.put("author", Constants.INITIAL_AUTHOR);
        updateBook.put("title", Constants.INITIAL_TITLE);

        given()
                .header("Content-Type", "application/json")
                .body(updateBook.toJSONString())
        .when()
                .put("/"+ Constants.UNUSED_ID)
        .then()
                .statusCode(400)
                .body(equalTo("No such identifier found"));
    }
}