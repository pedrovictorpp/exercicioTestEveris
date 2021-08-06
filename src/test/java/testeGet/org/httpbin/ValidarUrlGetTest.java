package testeGet.org.httpbin;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import testeGet.org.httpbin.Utils.BaseApi;

public class ValidarUrlGetTest extends BaseApi{

	@Test
	public void getURLTest() {
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("/get")
		.then()
			.log().all()
			.statusCode(HttpStatus.SC_OK)
			.body("url", containsString("https://httpbin.org/get"));
	}

}
