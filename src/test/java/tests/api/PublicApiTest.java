package tests.api;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PublicApiTest {

    @Test
    public void testOfficialJokeApi() {
        given()
        .when()
            .get("https://official-joke-api.appspot.com/jokes/programming/random")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("[0].setup", notNullValue())
            .body("[0].punchline", notNullValue());
    }

    @Test
    public void testCoffeeApi() {
        given()
        .when()
            .get("https://coffee.alexflipnote.dev/random.json")
        .then()
            .statusCode(200)
            .body("file", not(emptyOrNullString()));
    }

    @Test
    public void testOpenTopoDataApi() {
        given()
        .when()
            .get("https://api.opentopodata.org/v1/srtm90m?locations=-43.5,172.5|27.6,1.98&interpolation=cubic")
        .then()
            .statusCode(200)
            .body("results", hasSize(2));
    }

    @Test
    public void testKmbBusRouteApi() {
        given()
        .when()
            .get("https://data.etabus.gov.hk/v1/transport/kmb/route/")
        .then()
            .statusCode(200)
            .body("data", not(empty()));
    }

  
}
