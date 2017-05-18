package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProdottiErogatiTest {

	ProdottiErogati prodstest = new ProdottiErogati();
	
	@Test
	public void testProdottiErogati() throws Exception {
		ProdottiErogati prods = new ProdottiErogati();
		assertNotNull(prods);
	}

	@Test
	public void testProdottiErogatiDistributoreProdotto() throws Exception {
		ProdottiErogati prods = new ProdottiErogati(new Distributore(), new Prodotto());
		assertNotNull(prods);
		assertNotNull(prods.getDistributore());
		assertNotNull(prods.getProdotto());
	}

	@Test
	public void testProdottiErogatiDistributoreProdottoIntegerIntegerInteger() throws Exception {
		ProdottiErogati prods = new ProdottiErogati(new Distributore(), new Prodotto(), 0, 3, 1);
		assertNotNull(prods);
		assertNotNull(prods.getDistributore());
		assertNotNull(prods.getProdotto());
		assertTrue(prods.getPosto()==3);
		assertTrue(prods.getScaffale()==0);
		assertTrue(prods.getQuantita()==1);
	}

	@Test
	public void testSetId() throws Exception {
		prodstest.setId(0);
		assertTrue(prodstest.getId()==0);
	}

	@Test
	public void testSetDistributore() throws Exception {
		prodstest.setDistributore(new Distributore());
		assertNotNull(prodstest.getDistributore());
	}

	@Test
	public void testSetProdotto() throws Exception {
		prodstest.setProdotto(new Prodotto());
		assertNotNull(prodstest.getProdotto());
	}

	@Test
	public void testSetScaffale() throws Exception {
		prodstest.setScaffale(0);
		assertTrue(prodstest.getScaffale()==0);
	}

	@Test
	public void testSetPosto() throws Exception {
		prodstest.setPosto(3);
		assertTrue(prodstest.getPosto()==3);
	}

	@Test
	public void testSetQuantita() throws Exception {
		prodstest.setQuantita(2);
		assertTrue(prodstest.getQuantita()==2);
	}

}
