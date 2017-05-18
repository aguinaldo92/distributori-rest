package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class StabilimentoTest {

	Stabilimento stabtest = new Stabilimento();
	
	@Test
	public void testStabilimentoProduttore() throws Exception {
		Stabilimento stab = new Stabilimento(new Produttore());
		assertNotNull(stab);
		assertNotNull(stab.getProduttore());
	}

	@Test
	public void testStabilimentoProduttoreStringStringSet() throws Exception {
		Set<Prodotto> prods = new HashSet<Prodotto>();
		prods.add(new Prodotto());
		Stabilimento stab = new Stabilimento(new Produttore(), "Bagnolo City", "LE", prods);
		assertEquals("LE",stab.getProvincia());
		assertTrue(stab.getProdottos().size()==1);
	}

	@Test
	public void testSetId() throws Exception {
		stabtest.setId(0);
		assertTrue(stabtest.getId()==0);
	}

	@Test
	public void testSetProduttore() throws Exception {
		stabtest.setProduttore(new Produttore());
		assertNotNull(stabtest.getProduttore());
	}

	@Test
	public void testSetCitta() throws Exception {
		stabtest.setCitta("City");
		assertEquals("City",stabtest.getCitta());
	}

	@Test
	public void testSetProvincia() throws Exception {
		stabtest.setProvincia("LE");
		assertEquals("LE",stabtest.getProvincia());
	}

	@Test
	public void testSetProdottos() throws Exception {
		Set<Prodotto> prods = new HashSet<Prodotto>();
		prods.add(new Prodotto());
		prods.add(new Prodotto());
		stabtest.setProdottos(prods);
		assertTrue(stabtest.getProdottos().size()==2);
	}
	
}
