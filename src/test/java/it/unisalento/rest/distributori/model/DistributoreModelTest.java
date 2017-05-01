package it.unisalento.rest.distributori.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Test;

public class DistributoreModelTest {

	DistributoreModel distribtest = new DistributoreModel();
	
	@Test
	public void testSetId() throws Exception {
		distribtest.setId(0);
		assertTrue(distribtest.getId()==0);
	}

	@Test
	public void testSetLat() throws Exception {
		distribtest.setLat(BigDecimal.valueOf(9));
		assertTrue(distribtest.getLat().equals(BigDecimal.valueOf(9)));
	}

	@Test
	public void testSetLon() throws Exception {
		distribtest.setLon(BigDecimal.valueOf(9));
		assertTrue(distribtest.getLon().equals(BigDecimal.valueOf(9)));
	}

	@Test
	public void testSetPosizioneEdificio() throws Exception {
		distribtest.setPosizioneEdificio("Posizione esempio");
		assertEquals("Posizione esempio", distribtest.getPosizioneEdificio());
	}

	@Test
	public void testSetIndirizzo() throws Exception {
		distribtest.setIndirizzo("Indirizzo esempio");
		assertEquals("Indirizzo esempio", distribtest.getIndirizzo());
	}

	@Test
	public void testSetCategorieFornite() throws Exception {
		distribtest.setCategorieFornite("List of categories");
		assertEquals("List of categories", distribtest.getCategorieFornite());
	}

}
