package tests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetAndPost {
	
	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name",equalTo("George")).
		body("data.first_name",hasItems("George","Rachel")).
		log().all();
		
	}

	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Neha");
//		map.put("job", "Student");
//		System.out.println(map);
//		JSONObject request = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Neha");
		request.put("job", "Student");
		System.out.println(request);
		baseURI = "https://reqres.in/api";
		given().header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
		
	}
}
