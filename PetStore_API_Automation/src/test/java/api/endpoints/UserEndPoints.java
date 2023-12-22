package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

// UserEndPoints.java
// Create for perform Create, read, Update, Delete requests the user API

public class UserEndPoints {

			
		public static Response CreateUser(User PayLoad)
		{		
			Response reponse = 	given()
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(PayLoad)
								.when()
									.post(Routes.post_url);	
			return reponse;
		}
		
		
		public static Response readUser(String userName)
		{
			
			Response reponse = 	given()
									.pathParam("username", userName)
								.when()
									.get(Routes.get_url);		
			return reponse;
		}
		
		
		public static Response updateUser(String userName, User payload)
		{
			
			Response reponse = 	given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", userName)
								.body(payload)
							.when()
								.put(Routes.update_url);
			return reponse;
		}
		
		
		public static Response deleteUser(String userName)
		{
			
			Response reponse = 	given()
									.pathParam("username", userName)
								.when()
									.delete(Routes.delete_url);		
			return reponse;
		}
	
}
