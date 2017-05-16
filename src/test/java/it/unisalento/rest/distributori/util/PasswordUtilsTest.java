package it.unisalento.rest.distributori.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordUtilsTest {

	@Test
	public void testGetSha256() throws Exception {
		String pw256 = PasswordUtils.getSha256("password-prova");
		assertTrue(pw256.equals("ae1fb78a8928bb7e212e5fdb87362e8ec45b0052eec5349e8cf6ba55b3cd0b8e"));
	}

}
