package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class FamiglieProdottoTest {

	@Test
	public void testFamiglieProdotto() throws Exception {
		FamiglieProdotto fams = new FamiglieProdotto();
		assertNotNull(fams);
	}

	@Test
	public void testFamiglieProdottoFamigliaProdotto() throws Exception {
		FamiglieProdotto fams = new FamiglieProdotto(new Famiglia("Esempio"), new Prodotto());
		assertNotNull(fams);
		assertEquals("Esempio",fams.getFamiglia().getNome());
		assertNotNull(fams.getProdotto());
	}

	@Test
	public void testSetId() throws Exception {
		FamiglieProdotto fams = new FamiglieProdotto();
		fams.setId(0);
		assertTrue(fams.getId()==0);
	}

	@Test
	public void testSetFamiglia() throws Exception {
		FamiglieProdotto fams = new FamiglieProdotto();
		fams.setFamiglia(new Famiglia("JUnit"));
		assertEquals("JUnit", fams.getFamiglia().getNome());
	}

	@Test
	public void testSetProdotto() throws Exception {
		FamiglieProdotto fams = new FamiglieProdotto();
		fams.setProdotto(new Prodotto());
		assertNotNull(fams.getProdotto());
	}
}
