package it.unisalento.rest.distributori.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FCMTokenTest {

	@Test
	public void testSetToken() throws Exception {
		FCMToken tokentest = new FCMToken();
		tokentest.setToken("token");
		assertEquals("token", tokentest.getToken());
	}

}
