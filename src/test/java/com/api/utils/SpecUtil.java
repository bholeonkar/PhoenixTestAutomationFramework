package com.api.utils;

import static com.api.constant.Roles.FD;
import static com.api.utils.AuthTokenProvider.getToken;

import javax.management.relation.Role;

import org.apache.http.client.methods.RequestBuilder;
import org.hamcrest.Matchers;

import com.api.constant.Roles;
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
	
	public static RequestSpecification requestSpec(Object payload) {
		// To take care of the common request sections(methods)
		
		RequestSpecification request=new RequestSpecBuilder()
				.setBaseUri(ConfigManager.getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.setBody(payload)
				.log(LogDetail.URI)
				.log(LogDetail.METHOD)
				.log(LogDetail.HEADERS)
				.log(LogDetail.BODY)
				.build();
				
				return request;
	}
	
	
//	public static ResponseSpecification responseSpec() {
//	ResponseSpecification responseSpecification = new ResponseSpecBuilder()
//	.expectContentType(ContentType.JSON)
//	.expectStatusCode(200)
//	.expectResponseTime(Matchers.lessThan(1000L))
//	.log(LogDetail.ALL)
//	.build();
//	
//	return responseSpecification;
//	}
//	
	
	public static RequestSpecification requestSpecWithAuth(Roles role) {
		RequestSpecification requestSpecification=new RequestSpecBuilder()
				.setBaseUri(ConfigManager.getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.addHeader("Authorization", getToken(FD))
				.log(LogDetail.URI)
				.log(LogDetail.METHOD)
				.log(LogDetail.HEADERS)
				.log(LogDetail.BODY)
				.build();
				
				return requestSpecification;
	}
	
	
	public static ResponseSpecification responseSpec_TEXT(int statusCode) {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectStatusCode(statusCode)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		return responseSpecification;
		}
	
	public static ResponseSpecification responseSpec_JSON(int statusCode) {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		return responseSpecification;
		}
	
	
	public static ResponseSpecification responseSpec_ok() {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		return responseSpecification;
		}
}
