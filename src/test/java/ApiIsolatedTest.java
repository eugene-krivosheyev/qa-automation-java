import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class ApiIsolatedTest {
    private Connection connection;

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

    @BeforeEach
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost/app-db",
                "app-db-admin",
                "P@ssw0rd"
        );
    }

    @AfterEach
    public void disconnect() throws SQLException {
        connection.close();
    }

    @Test
    public void shouldGetCountryWhenExists() throws SQLException {
        PreparedStatement sql = connection.prepareStatement(
                "INSERT INTO country(id, country_name) VALUES(?,?)"
        );
        sql.setInt(1, 200);
        sql.setString(2, "20");
        sql.executeUpdate();


        when()
                .get("/api/countries")
        .then()
                .statusCode(200)
                .body("", hasItem(
                               hasEntry("countryName","20")
                ));

    }
}
