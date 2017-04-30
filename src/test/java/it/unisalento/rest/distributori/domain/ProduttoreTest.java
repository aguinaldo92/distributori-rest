package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ProduttoreTest {

	@Test
	public void testProduttoreStringStringSet() throws Exception {
		Set<Stabilimento> stabs = new HashSet<Stabilimento>();
		stabs.add(new Stabilimento());
		stabs.add(new Stabilimento());
		Produttore produttore = new Produttore("JUnit", "Sede esempio", stabs);
		assertNotNull(produttore);
		assertTrue(produttore.getStabilimentos().size()==2);
		assertEquals("JUnit",produttore.getNome());
	}
	
}
