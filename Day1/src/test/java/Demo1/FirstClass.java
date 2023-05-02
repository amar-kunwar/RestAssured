package Demo1;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;
import com.google.common.hash.HashCode;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class FirstClass {
	int id=4;
	
	//String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjA5LCJlbWFpbCI6ImFtYXJrdW53QGdtYWlsLmNvbSIsImlhdCI6MTY3OTQ4MTQ4MX0.7yTVADIf9dV93g7Qkr9dR758oNkGQzMr4Q_eGSa9Kok";

	// Givem
	// When
	// then 
	
	@Test		
	void GetUser()
	{
		
		
		
		
	//	H 'accept: application/json' \
		//  -H 'Accept-Language: en' \
		//  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjA5LCJlbWFpbCI6ImFtYXJrdW53QGdtYWlsLmNvbSIsImlhdCI6MTY3OTQ4MTQ4MX0.7yTVADIf9dV93g7Qkr9dR758oNkGQzMr4Q_eGSa9Kok'
		
		given()
		
		.header("Authorization", "Token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjA5LCJlbWFpbCI6ImFtYXJrdW53QGdtYWlsLmNvbSIsImlhdCI6MTY3OTQ4MTQ4MX0.7yTVADIf9dV93g7Qkr9dR758oNkGQzMr4Q_eGSa9Kok")
		.header("Accept-Language", "en")
		.header("contentType","application/json")
		
		 //header("Id", "abc").
		//  header("name","name").
		//  header("","")
		//.contentType("application/json")
		//.a
		//.header("Authorization", "Bearer " + token)
		
		
		
		
		.when()
		.get("https://nobelpagedevapi.iworklab.com/api/v1/user/profile/0")
		
		
		.then()
		.statusCode(200)
		//.body("page",equalTo(2))
		.log().all();
	}
	//@Test (priority = 2)
	void CreateUser()
	{
		
	HashMap<String, String> hm = new HashMap<String, String>();
	hm.put("name", "amar");
	hm.put("job", "leader");
		
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		
		//.then()
		//.statusCode(201)
		//.log().all();
	}
	
	//@Test (priority = 3, dependsOnMethods =  "CreateUser")
	void UpdateUser()
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "amar");
		hm.put("job", "leader");
			
			given()
			.contentType("application/json")
			.body(hm)
			.when()
			.post("https://reqres.in/api/users/"+id)
			
			
			.then()
			.statusCode(201)
			.log().all();
		
	}
	
	//@Test (priority = 4)
	void DeleteUser()
	{
					
			given()
			
			.when()
			.delete("https://reqres.in/api/users/"+id)
				
			.then()
			.statusCode(204)
			.log().all();
		
	}
	
	
	
}
