import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    public void testGetRequest() {
        given()
        .baseUri("https://postman-echo.com")
        .when()
        .get("/get?foo1=bar1&foo2=bar2")
        .then()
        .log().body()
        .statusCode(200)
        .body("args.foo1", equalTo("bar1"))
        .body("args.foo2", equalTo("bar2"));
    }
    @Test
    public void testPostRawText() {
        String requestBody="This is expected to be sent back as part of response body";
        given()
        .baseUri("https://postman-echo.com")
        .contentType("text/plain")
        .body(requestBody)
        .when()
        .post("/post")
        .then()
        .log().body()
        .statusCode(200)
        .body("data", equalTo(requestBody));
    }
    @Test 
    public void testPostFromData() {
        given()
        .baseUri("https://postman-echo.com")
        .contentType("application/x-www-form-urlencoded")
        .formParam("foo1", "bar1")
        .formParam("foo2", "bar2")
        .when()
        .post("/post")
        .then()
        .log().body()
        .statusCode(200)
        .body("form.foo1", equalTo("bar1"))
        .body("form.foo2", equalTo("bar2"));
    }
    @Test 
    public void testPutRequest() {
        String requestBody="This is expected to be sent back as part of response body.";
        given()
        .baseUri("https://postman-echo.com")
        .contentType("text/plain")
        .body(requestBody)
        .when()
        .put("/put")
        .then()
        .log().body()
        .statusCode(200)
        .body("data", equalTo(requestBody));
    }
    @Test 
    public void testPatchRequest() {
        String requestBody="This is expected to be sent back as part of response body.";
        given()
        .baseUri("https://postman-echo.com")
        .contentType("text/plain")
        .body(requestBody)
        .when()
        .patch("/patch")
        .then()
        .log().body()
        .statusCode(200)
        .body("data", equalTo(requestBody));
    }
    @Test 
    public void testDeleteRequest() {
        given()
        .baseUri("https://postman-echo.com")
        .when()
        .delete("/delete")
        .then()
        .log().body()
        .statusCode(200);
    }
}
