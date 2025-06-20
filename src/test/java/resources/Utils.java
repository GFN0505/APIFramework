package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {//This is used to store reusable methods
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	
	{
		if (req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 req = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl")).addHeader("Authorization", "FLWSECK-dc63611d01f0d12a05a67473ac618460-195afc6eddcvt-X")
		        .addFilter(RequestLoggingFilter.logRequestTo(log))
		        .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
		 return req;
		 
		}
		return req;
	}
	
	 public String getGlobalValues(String key) throws IOException
	 {
		 Properties prop = new Properties();
		 FileInputStream fis = new FileInputStream("/Users/godsfavournwoko/APIFramework/src/test/java/resources/global.properties");
		 prop.load(fis);//loading fis to prop
		 return prop.getProperty(key);
	 }

	 
}
