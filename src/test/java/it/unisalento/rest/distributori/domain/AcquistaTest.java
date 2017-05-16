package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

public class AcquistaTest {
Acquista acqtest = new Acquista();
	
	@Test
	public void testAcquista() throws Exception {
		Acquista acq = new Acquista();
		assertNotNull(acq);
	}

	@Test
	public void testAcquistaProdotto() throws Exception {
		Acquista acq = new Acquista(new Prodotto());
		assertNotNull(acq);
		assertNotNull(acq.getProdotto());
	}

	@Test
	public void testAcquistaDistributorePersonaProdottoDateIntegerBigDecimal() throws Exception {
		Acquista acq = new Acquista(new Distributore(), new Persona(), new Prodotto(), new Date(), 10, BigDecimal.valueOf(8));
		assertNotNull(acq);
		assertNotNull(acq.getDistributore());
		assertNotNull(acq.getPersona());
		assertNotNull(acq.getProdotto());
		assertNotNull(acq.getData());
		assertTrue(acq.getQuantita()==10);
		assertTrue(acq.getTotaleSpesa()==BigDecimal.valueOf(8));
	}

	@Test
	public void testSetId() throws Exception {
		acqtest.setId(0);
		assertTrue(acqtest.getId()==0);
	}
	
	@Test
	public void testSetDistributore() throws Exception {
		acqtest.setDistributore(new Distributore());
		assertNotNull(acqtest.getDistributore());
	}

	@Test
	public void testSetPersona() throws Exception {
		acqtest.setPersona(new Persona());
		assertNotNull(acqtest.getPersona());
	}

	@Test
	public void testSetProdotto() throws Exception {
		acqtest.setProdotto(new Prodotto());
		assertNotNull(acqtest.getProdotto());
	}

	@Test
	public void testSetData() throws Exception {
		Date data = new Date();
		acqtest.setData(data);
		assertEquals(data,acqtest.getData());
	}

	@Test
	public void testSetQuantita() throws Exception {
		acqtest.setQuantita(10);
		assertTrue(acqtest.getQuantita()==10);
	}

	@Test
	public void testSetTotaleSpesa() throws Exception {
		acqtest.setTotaleSpesa(BigDecimal.valueOf(14));
		assertEquals(BigDecimal.valueOf(14),acqtest.getTotaleSpesa());
	}

}
