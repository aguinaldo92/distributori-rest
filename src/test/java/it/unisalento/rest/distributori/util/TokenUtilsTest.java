package it.unisalento.rest.distributori.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TokenUtilsTest {

	@Test
	public void testTokenBuilder() throws Exception {
		String tk = TokenUtils.tokenBuilder(5);
		assertNotNull(tk);
	}

}
