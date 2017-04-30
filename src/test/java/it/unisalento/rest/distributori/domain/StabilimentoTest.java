package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class StabilimentoTest {

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
	
}
