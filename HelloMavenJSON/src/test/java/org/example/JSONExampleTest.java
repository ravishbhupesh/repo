package org.example;

import org.json.JSONArray;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class JSONExampleTest extends TestCase {
	
	private JSONExample example = new JSONExample();

	public JSONExampleTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
		return new TestSuite(JSONExampleTest.class);
	}
	
	public void testGetATMForCity(){
		JSONArray result = example.getATMForCity("UTRECHT");
		assertNotNull(result);
	}
	
	public void testGetATMForPostcode(){
		JSONArray result = example.getATMForPostcode("3564");
		assertNotNull(result);
		assertEquals(1, result.length());
	}
}
