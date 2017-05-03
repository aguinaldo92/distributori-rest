package it.unisalento.rest.distributori.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class UtenteLocationModelTest {
	
	UtenteLocationModel loctest = new UtenteLocationModel();

	@Test
	public void testSetLat() throws Exception {
		loctest.setLat(BigDecimal.valueOf(9));
		assertTrue(loctest.getLat().equals(BigDecimal.valueOf(9)));
	}

	@Test
	public void testSetLon() throws Exception {
		loctest.setLon(BigDecimal.valueOf(9));
		assertTrue(loctest.getLon().equals(BigDecimal.valueOf(9)));
	}

	@Test
	public void testSetDistanza() throws Exception {
		loctest.setDistanza(80);
		assertTrue(loctest.getDistanza()==80);
	}

}
