package tests._1positiveTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import tests.Base;
import tests.Constants;

public class _2AddBookTest extends Base {

    @Test
    public void addBookWithId(){

        JSONObject book = new JSONObject();

        book.put("id", Constants.INITIAL_ID);
        book.put("author", Constants.INITIAL_AUTHOR);
        book.put("title", Constants.INITIAL_TITLE);

        given()
                .header("Content-Type", "application/json")
                .body(book.toJSONString())
        .when()
                .post("/")
        .then()
                .statusCode(201)
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .body("id", equalTo(Constants.INITIAL_ID))
                .body("author", equalTo(Constants.INITIAL_AUTHOR))
                .body("title", equalTo(Constants.INITIAL_TITLE));
    }

    @Test
    public void addBookWithoutId(){

        JSONObject book = new JSONObject();

        book.put("author", Constants.INITIAL_AUTHOR);
        book.put("title", Constants.INITIAL_TITLE);

        given()
                .header("Content-Type", "application/json")
                .body(book.toJSONString())
                .when()
                .post("/")
                .then()
                .statusCode(201)
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .body("author", equalTo(Constants.INITIAL_AUTHOR))
                .body("title", equalTo(Constants.INITIAL_TITLE));
    }
}