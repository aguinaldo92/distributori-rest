package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class DistributoreTest {

	Distributore distrib_test = new Distributore();
	
	@Test
	public void testDistributore() throws Exception {
		Distributore distributore = new Distributore();
		assertNotNull(distributore);
	}

	@Test
	public void testSetId() throws Exception {
		distrib_test.setId(0);
		assertTrue(distrib_test.getId()==0);
	}

	@Test
	public void testSetLat() throws Exception {
		distrib_test.setLat(BigDecimal.valueOf(10));
		assertTrue(distrib_test.getLat().equals(BigDecimal.valueOf(10)));
	}

	@Test
	public void testSetLon() throws Exception {
		distrib_test.setLon(BigDecimal.valueOf(10));
		assertTrue(distrib_test.getLon().equals(BigDecimal.valueOf(10)));
	}

	@Test
	public void testSetIndirizzo() throws Exception {
		distrib_test.setIndirizzo("Via Esempio");
		assertEquals("Via Esempio", distrib_test.getIndirizzo());
	}

	@Test
	public void testSetPosizioneEdificio() throws Exception {
		distrib_test.setPosizioneEdificio("Posizione Esempio");
		assertEquals("Posizione Esempio", distrib_test.getPosizioneEdificio());
	}

	@Test
	public void testSetStato() throws Exception {
		distrib_test.setStato(0);
		assertTrue(distrib_test.getStato()==0);
	}

	@Test
	public void testSetNumScaffali() throws Exception {
		distrib_test.setNumScaffali(9);
		assertTrue(distrib_test.getNumScaffali()==9);
	}

	@Test
	public void testSetNumPosti() throws Exception {
		distrib_test.setNumPosti(9);
		assertTrue(distrib_test.getNumPosti()==9);
	}

	@Test
	public void testSetAcquistas() throws Exception {
		Set<Acquista> acquistas = new HashSet<Acquista>();
		acquistas.add(new Acquista());
		acquistas.add(new Acquista());
		acquistas.add(new Acquista());
		distrib_test.setAcquistas(acquistas);
		assertTrue(distrib_test.getAcquistas().size()==3);
	}

	@Test
	public void testSetCategorieFornites() throws Exception {
		Set<CategorieFornite> categs = new HashSet<CategorieFornite>();
		categs.add(new CategorieFornite());
		distrib_test.setCategorieFornites(categs);
		assertTrue(distrib_test.getCategorieFornites().size()==1);
	}

	@Test
	public void testSetProdottiErogatis() throws Exception {
		Set<ProdottiErogati> prods = new HashSet<ProdottiErogati>();
		prods.add(new ProdottiErogati());
		prods.add(new ProdottiErogati());
		distrib_test.setProdottiErogatis(prods);
		assertTrue(distrib_test.getProdottiErogatis().size()==2);
	}


}
