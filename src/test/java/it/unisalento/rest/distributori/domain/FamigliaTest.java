package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FamigliaTest {

	@Test
	public void testFamiglia() throws Exception {
		Famiglia fam = new Famiglia();
		assertNotNull(fam);
	}

	@Test
	public void testFamigliaString() throws Exception {
		Famiglia fam = new Famiglia("JUnit Family");
		assertEquals("JUnit Family",fam.getNome());
	}

	@Test
	public void testFamigliaStringSet() throws Exception {
		Set<FamiglieProdotto> prods = new HashSet<FamiglieProdotto>();
		prods.add(new FamiglieProdotto());
		Famiglia fam = new Famiglia("JUnit Family", prods);
		assertEquals("JUnit Family", fam.getNome());
		assertTrue(fam.getFamiglieProdottos().size()==1);
	}

	@Test
	public void testSetId() throws Exception {
		Famiglia fam = new Famiglia();
		fam.setId(0);
		assertTrue(fam.getId()==0);
	}

	@Test
	public void testSetNome() throws Exception {
		Famiglia fam = new Famiglia();
		fam.setNome("JUnit");
		assertEquals("JUnit",fam.getNome());
	}

	@Test
	public void testSetFamiglieProdottos() throws Exception {
		Famiglia fam = new Famiglia();
		Set<FamiglieProdotto> prods = new HashSet<FamiglieProdotto>();
		prods.add(new FamiglieProdotto());
		prods.add(new FamiglieProdotto());
		fam.setFamiglieProdottos(prods);
		assertTrue(fam.getFamiglieProdottos().size()==2);
	}

}
