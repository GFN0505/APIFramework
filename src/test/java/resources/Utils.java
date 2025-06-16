package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {//This is used to store reusable methods
	
	RequestSpecification req;
	public RequestSpecification requestSpecification() throws FileNotFoundException
	
	{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 req = new RequestSpecBuilder().setBaseUri("https://f4b-v3-dashboard-staging-api.sandbox-flutterwave.com").addHeader("Authorization", "FLWSECK-dc63611d01f0d12a05a67473ac618460-195afc6eddcvt-X")
		        .addFilter(RequestLoggingFilter.logRequestTo(log))
		        .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
		 return req;
	}

}
