package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ProduttoreTest {

	Produttore prodtest = new Produttore();

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

	@Test
	public void testSetId() throws Exception {
		prodtest.setId(0);
		assertTrue(prodtest.getId()==0);
	}

	@Test
	public void testSetNome() throws Exception {
		prodtest.setNome("Name");
		assertEquals("Name",prodtest.getNome());
	}

	@Test
	public void testSetSede() throws Exception {
		prodtest.setSede("Sede");
		assertEquals("Sede",prodtest.getSede());
	}

	@Test
	public void testSetStabilimentos() throws Exception {
		Set<Stabilimento> stabs = new HashSet<Stabilimento>();
		stabs.add(new Stabilimento());
		prodtest.setStabilimentos(stabs);
		assertTrue(prodtest.getStabilimentos().size()==1);
	}
}
