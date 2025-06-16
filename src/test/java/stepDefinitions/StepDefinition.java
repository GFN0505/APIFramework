package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends  Utils { //Extends is used for inheritance to allow this class inherit the methods in another class without having to create an object
	TestDataBuild data = new TestDataBuild();// to get data from TestDataBuild class
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response; //These are declared globally so they can accessed in different methods
	
	
	@Given("RWF Payout Payload")
	public void rwf_payout_payload() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification())
		.body(data.rwfPayoutPayload()); 
		
	}
	@When("user calls {string} with Post http request and sets currency as {string}")
	public void user_calls_with_post_http_request_and_sets_currency_as(String string1, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response = res.when().post("/v3/transfers")
				.then().spec(resspec).extract().response();
	    
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
