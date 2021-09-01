package tests._2negativeTests;

import org.testng.annotations.Test;
import tests.Base;
import tests.Constants;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class _4DeleteBookByIdTest extends Base {
    @Test
    public void DeleteBookById(){

        when()
                .delete("/"+ Constants.UNUSED_ID)
        .then()
                .statusCode(400);
    }
}