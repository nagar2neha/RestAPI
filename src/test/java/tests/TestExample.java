package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
public class TestExample {
	@Test
	public void test1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		int statusCode = response.getStatusCode();
		System.out.println(response.getStatusCode());
		System.out.println("Time--->"+response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("Content-Type"));
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test2() {
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).body("data[1].id",equalTo(8)).log().all();
		
	}
	

}
