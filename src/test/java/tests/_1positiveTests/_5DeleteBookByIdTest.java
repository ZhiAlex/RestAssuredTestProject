package tests._1positiveTests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import tests.Base;
import tests.Constants;

public class _5DeleteBookByIdTest extends Base {
    @Test
    public void DeleteBookById(){

        when()
                .delete("/"+ Constants.INITIAL_ID)
        .then()
                .statusCode(204);
    }
}