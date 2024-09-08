package page;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.AddNewPlaceData;
import pojo.Location;
import pojo.NewPageResponse;

public class AddPlace {

	@Test
	public void Addnewplacegoogle() {
		
		AddNewPlaceData d=new AddNewPlaceData();
		Location l=new Location();
		
		List<String> list =new ArrayList<>();
		list.add("shoe park");
		list.add("shop");
		
		l.setLat(-38.383494);
		l.setLng(33.427362);
		d.setLoaction(l);
		d.setAccuracy(50);
		d.setName("Frontline house");
		d.setPhone_number("(+91) 983 893 3937");
		d.setAddress("29, side layout, cohen 09");
		d.setTypes(list);
		d.setWebsite("http://google.com");
		d.setLanguage("French-IN");
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
			
		NewPageResponse res = given().log().all().queryParam("key", "qaclick123").body(d).
		when().post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).extract().response().as(NewPageResponse.class);
		String status=  res.getStatus();
		assertEquals(status, "OK"); 
		
		String scope=res.getScope();
		assertEquals(scope, "APP");
		
	    String	id=res.getId();
	    System.out.println(id);
	    
	    String refer =res.getReference();
	    System.out.println(refer);

	}
	
}
