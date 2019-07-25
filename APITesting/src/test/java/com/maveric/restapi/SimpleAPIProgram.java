package com.maveric.restapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;

import io.restassured.RestAssured;

import io.restassured.http.Method;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Listeners(com.maveric.restapi.ListennersExample.class)
public class SimpleAPIProgram {

	
	@Test(enabled=true)
	void  test()
	{
		
		RestAssured.baseURI="https://samples.openweathermap.org";
		RequestSpecification req=RestAssured.given();
		Response res=req.request(Method.GET,"/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		String resoutputbody=res.getBody().asString();
		int rescode=res.getStatusCode();
		System.out.println("Res body"+resoutputbody);
		System.out.println("Response code"+rescode);
	}
	
	
	@Test(enabled=true)
	 
	public void test2()
	{
		RestAssured.baseURI="http://services.grouplet.com";
		RequestSpecification req=RestAssured.given();
		Response res=req.request(Method.GET,"/country/get/all");
	
		String resoutputbody=res.getBody().asString();
		int rescode=res.getStatusCode();
		System.out.println("Res body"+resoutputbody);
		System.out.println("Response code"+rescode);


	}
	
	
	@Test(enabled=true)
	
	public void one() throws IOException
	{
		
	FileInputStream fs = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Six sigma Training\\example.json");
	RestAssured.baseURI="http://api.openweathermap.org/data/3.0/stations";
	Response response =
			 RestAssured.given().header("Content-Type","application/json")			
			.and()
			.body(IOUtils.toString(fs,"UTF-8")).when().post("");
	System.out.println(response.asString());
	System.out.println(response.getStatusCode());
	}
	
@Test(enabled=true)
public void four()
{
	RestAssured.given()
	.when()
	.get("https://samples.openweathermap.org")
	.then()
	.assertThat()
	.statusCode(200);
	
	RestAssured.baseURI="";
	
	

	
	Response response=
			RestAssured.given()
			.when()
			.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	String responseAsString=response.asString();
	System.out.println("Headers --------------------------->"+response.getHeaders());
	RestAssured.given().header("Content-type","text/xml").and().body("").when().post("");
	System.out.println("Response ------------------->"+responseAsString);
	System.out.println("Status "+response.getStatusCode());
	JsonPath json=new JsonPath(responseAsString);
	System.out.println(json.get("weather").toString());
	
	Map<String, Integer> test=json.getMap("sys");
	for(Map.Entry<String, Integer> entry:test.entrySet())
	{
		System.out.println(entry.getKey()+" - "+entry.getValue());
	}
	
	System.out.println(json.get("weather.id").toString());
	System.out.println(json.get("weather.description").toString());
	System.out.println(json.get("wind").toString());	

}

@Test(enabled=true)
public void five() throws IOException
{
	FileInputStream fs = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Six sigma Training\\example.json");
	Response response=RestAssured.given().header("Content-Type","application/json")			
	.and().body(IOUtils.toString(fs,"UTF-8")).when().post("https://samples.openweathermap.org/data/3.0/stations?appid=b1b15e88fa797225412429c1c50c122a1");
	System.out.println("Response "+response.asString());
	
}

}