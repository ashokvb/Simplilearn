package com.StudentPortal.Pages;

import org.testng.Assert;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import  io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.framework.base.BasePage;
import com.framework.base.constants.FrameworkConstants;
import com.framework.driver.WebUIDriver;
import static com.framework.elements.Locator.byXPath;
import static com.framework.elements.Locator.byId;
import static com.framework.elements.Locator.byLinkText;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.EmptyFileException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.elements.Button;
import com.framework.elements.Checkbox;
import com.framework.elements.CustomAsserts;
import com.framework.elements.Dropbox;
import com.framework.elements.Label;
import com.framework.elements.Table;
import com.framework.elements.TextField;
import com.framework.restAPI.RestClient;
import com.framework.restAPI.URL;
import com.framework.util.DatesUtil;
import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;
import com.framework.elements.Link;
import com.framework.elements.PickList;
import com.framework.elements.RadioButton;

public class CreatingTerm extends RestClient{
	
	
	@Test(priority=1)
	public void CreatingnewTerm(StringHash data) throws IOException
	{	
		
		String token2 ="Q01DUFNVU0FAZHRzLmVkdTpEQGxsYTNDQG1wdSQ=";
		
		Response res = given()
				      .header("Authorization","Bearer "+token2)
				      .body("{\"username\":\"CMCPSUSA@dts.edu\",\"password\":\"D@lla3C@mpu$\"}")
				      .when().contentType(ContentType.JSON)
				      .get("https://sisclientweb-test-100888.campusnexus.cloud/api/commands/Academics/Term/SaveNew");
		              
		
		int code = res.getStatusCode();
		
		System.out.println("Status Code is " +code);
		
		System.out.println(res.getBody().asString());
		
		System.out.println(res.getStatusCode());
			
		System.out.println(res.getTime());
		
		Assert.assertEquals(code, 200);	
		
		String responseBodyAsString = res.getBody().asString();
		
		CustomAsserts.assertString(responseBodyAsString.contains(data.get("8754213098").toString()));
		CustomAsserts.assertString(responseBodyAsString.contains(data.get("01 -Laredo").toString()));
		CustomAsserts.assertString(responseBodyAsString.contains(data.get("New").toString()));
		Assert.assertTrue(responseBodyAsString.contains("New"));
		Assert.assertTrue(responseBodyAsString.contains("01/15/2021"));
		return;
         
	}

	private void body() {
		// TODO Auto-generated method stub
		
	}

	private Object log() {
		// TODO Auto-generated method stub
		return null;
	}

	private RequestSpecification then() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	//public void CreatingTerm(StringHash data) {
		// TODO Auto-generated method stub
		
	//}	
	