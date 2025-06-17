package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends  Utils { //Extends is used for inheritance to allow this class inherit the methods in another class without having to create an object
	TestDataBuild data = new TestDataBuild();// to get data from TestDataBuild class
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response; //These are declared globally so they can accessed in different methods
	
	
	@Given("RWF Payout Payload with {string} {string} {string}")
	public void rwf_payout_payload_with(String narration, String amount, String senderIdNumber) throws IOException {
	    int parsedAmount = Integer.parseInt(amount);
	    
	    res = given().spec(requestSpecification())
	                 .body(data.rwfPayoutPayload(narration, parsedAmount, senderIdNumber));
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_requests(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		
		APIResources resourceAPI = APIResources.valueOf(resource);  //This is for APIResources file
		resourceAPI.getResource();
		System.out.println(resourceAPI.getResource());
		
		ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if (method.equalsIgnoreCase("POST"))
		 response = res.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
		response = res.when().get(resourceAPI.getResource());
				
	    
	}
	@Then("The api call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
		
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		assertEquals(js.get(keyValue).toString(), ExpectedValue);
		
		
	}
	


}
