import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiDemoTest {
    @BeforeAll
    public static void setUpAuth() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("admin");
        RestAssured.authentication = authScheme;
    }

    @BeforeAll
    public static void setUpErrorLogging() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void shouldGetLocationsWhenPopulatedDb() {
        when()
                .get("/api/locations")
        .then()
                .statusCode(200)
                .body(
                        "size()", is(10),
                        "[0].city", is("West Hopefort")
                );
    }

    @Test
    public void shouldCreateCountryWhenUnique() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"countryName\": \"00\"\n" +
                        "}")
        .when()
                .post("/api/countries")
        .then()
                .statusCode(201)
                .body("id", not(empty()));
    }
}
