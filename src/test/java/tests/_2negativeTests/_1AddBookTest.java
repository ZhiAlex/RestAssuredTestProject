package tests._2negativeTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import tests.Base;
import tests.Constants;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _1AddBookTest extends Base {
    @Test
    public void addBookWithoutTitle(){

        JSONObject book = new JSONObject();

        book.put("id", Constants.INITIAL_ID);
        book.put("author", Constants.INITIAL_AUTHOR);

        given()
                .header("Content-Type", "application/json")
                .body(book.toJSONString())
        .when()
                .post("/")
        .then()
                .statusCode(400)
                .body(equalTo("Title not passed"));
    }
}