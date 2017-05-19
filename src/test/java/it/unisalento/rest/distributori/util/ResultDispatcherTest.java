package it.unisalento.rest.distributori.util;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.json.JSONObject;

public class ResultDispatcherTest {

	@Test
	public void testJsonError() throws Exception {
		JSONObject testJsonObject = ResultDispatcher.jsonError("test_message");
		assertNotNull(testJsonObject);
		assertFalse(testJsonObject.optBoolean("result"));
		assertTrue(testJsonObject.optString("message").compareTo("test_message") == 0);
		
	}

	@Test
	public void testJsonErrorUtf8Encoding() throws Exception {
		JSONObject testJsonObject = ResultDispatcher.jsonErrorUtf8Encoding();
		assertNotNull(testJsonObject);
		assertFalse(testJsonObject.optBoolean("result"));
		assertTrue(testJsonObject.optString("message").compareTo("utf-8 encoding not supported") == 0);
	}

	@Test
	public void testJsonErrorJWTCreation() throws Exception {
		JSONObject testJsonObject = ResultDispatcher.jsonErrorJWTCreation();
		assertNotNull(testJsonObject);
		assertFalse(testJsonObject.optBoolean("result"));
		assertTrue(testJsonObject.optString("message").compareTo("Invalid Signing configuration / Couldn't convert Claims") == 0);
	}

}
