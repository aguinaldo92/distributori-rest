package it.unisalento.rest.distributori.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class AcquistaModelTest {

	AcquistaModel acqtest = new AcquistaModel();
	
	@Test
	public void testSetIdProdottoErogato() throws Exception {
		acqtest.setIdProdottoErogato(0);
		assertTrue(acqtest.getIdProdottoErogato()==0);
	}

	@Test
	public void Quantita() throws Exception {
		acqtest.setQuantita(0);
		assertTrue(acqtest.getQuantita()==0);
	}

	@Test
	public void testSetTotale_spesa() throws Exception {
		acqtest.setTotale_spesa(BigDecimal.valueOf(9));
		assertEquals(BigDecimal.valueOf(9),acqtest.getTotale_spesa());
	}

	@Test
	public void testSetIdPersona() throws Exception {
		acqtest.setIdPersona(0);
		assertTrue(acqtest.getIdPersona()==0);
	}

	@Test
	public void testSetIdDistributore() throws Exception {
		acqtest.setIdDistributore(0);
		assertTrue(acqtest.getIdDistributore()==0);
	}

	@Test
	public void testSetIdProdotto() throws Exception {
		acqtest.setIdProdotto(0);
		assertTrue(acqtest.getIdProdotto()==0);
	}

}
