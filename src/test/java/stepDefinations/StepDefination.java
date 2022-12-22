package stepDefinations;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuilder;

import static io.restassured.RestAssured.given;
@RunWith(Cucumber.class)
public class StepDefination {
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	String parameter;
	@Given("Add PayLoad {string} {string} {string} {string} {string} {string}")
	public void add_PayLoad(String id,String title, String description, String pageCount, String excerpt,String publishDate) {
		int Id=Integer.parseInt(id);
		int pageCounts=Integer.parseInt(pageCount);
		 req=new RequestSpecBuilder().setBaseUri("https://fakerestapi.azurewebsites.net/api").
				 setContentType(ContentType.JSON).
				 build();
	    // Write code here that turns the phrase above into concrete actions
		 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 
		 res=given().spec(req).body(TestDataBuilder.AddBookPayLoad(Id,title,description,pageCounts,excerpt,publishDate)).log().all();
		
	}
	
	@Given("pass path  with {string}")
	public void pass_path_with(String parameter) {
		parameter=parameter;
	    // Write code here that turns the phrase above into concrete actions
		req=new RequestSpecBuilder().setBaseUri("https://fakerestapi.azurewebsites.net/api").
				 setContentType(ContentType.JSON).
				 build();
		 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 res=given().spec(req).log().all();
				 }


	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		System.out.println("Method="+method);
		
		 if(method.equalsIgnoreCase("POST"))
			 response =res.when().post(resourceAPI.getResource());
			else if(method.equalsIgnoreCase("GET"))
				 response =res.when().get(resourceAPI.getResource());
			else if(method.equalsIgnoreCase("Delete"))
				 response =res.when().delete(resourceAPI.getResource());
			else if(method.equalsIgnoreCase("PUT"))
				 response =res.when().put(resourceAPI.getResource());
	    
	}
	@Then("status in reponse is {int}")
	public void status_in_reponse_is(Integer expectedStatus) {
	    // Write code here that turns the phrase above into concrete actions
		response.prettyPrint();
		String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		Integer status=response.getStatusCode();
		System.out.print("Status="+status);
		assertEquals(status,expectedStatus);
	}


}
