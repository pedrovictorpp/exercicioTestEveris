package test.java.testeGet.org.httpbin.Utils;

import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;


public class BaseApi {
	
	@BeforeAll
	public static void preCondition() {
		baseURL = "https://httpbin.org/";
	}

}
