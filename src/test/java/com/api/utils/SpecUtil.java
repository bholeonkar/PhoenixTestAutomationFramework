package com.api.utils;

import org.apache.http.client.methods.RequestBuilder;

import com.api.pojo.UserCredentials;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtil {

	
	
	//GET--DEL
	public static RequestSpecification requestSpec() {
		// To take care of the common request sections(methods)
		
		RequestSpecification request=new RequestSpecBuilder()
		.setBaseUri(ConfigManager.getProperty("BASE_URI"))
		.setContentType(ContentType.JSON)
		.setAccept(ContentType.JSON)
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.log(LogDetail.BODY)
		.build();
		
		return request;
	}
	
	//POST-PUT-PATCH {BODY}
	
	public static ResponseSpecification requestSpec(UserCredentials userCreds) {
		// To take care of the common request sections(methods)
		
		ResponseSpecification responseSpecification=new ResponseSpecBuilder()
		.reson
	}
	
	
}
