package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unisalento.rest.distributori.factory.FactoryDao;

public class SottoscrizioniDistributoriTest {

	SottoscrizioniDistributori sottoscr_test = new SottoscrizioniDistributori();
	
	@Test
	public void testSottoscrizioniDistributori() throws Exception {
		SottoscrizioniDistributori sottoscr = new SottoscrizioniDistributori();
		assertNotNull(sottoscr);
	}

	@Test
	public void testSottoscrizioniDistributoriDistributorePersona() throws Exception {
		SottoscrizioniDistributori sottoscr = new SottoscrizioniDistributori(FactoryDao.getIstance().getDistributoreDao().get(3, Distributore.class), 
				FactoryDao.getIstance().getPersonaDao().get(19, Persona.class));
		assertNotNull(sottoscr);
		assertNotNull(sottoscr.getDistributore());
		assertNotNull(sottoscr.getPersona());
		assertTrue(sottoscr.getPersona().getCognome().equals("Muscatello"));
		assertTrue(sottoscr.getDistributore().getPosizioneEdificio().equals("Piano terra"));
	}

	@Test
	public void testSetId() throws Exception {
		sottoscr_test.setId(1);
		assertEquals((Integer) 1,sottoscr_test.getId());
	}

	@Test
	public void testSetDistributore() throws Exception {
		sottoscr_test.setDistributore(FactoryDao.getIstance().getDistributoreDao().get(3, Distributore.class));
		assertNotNull(sottoscr_test.getDistributore());
	}

	@Test
	public void testSetPersona() throws Exception {
		sottoscr_test.setPersona(FactoryDao.getIstance().getPersonaDao().get(19, Persona.class));
		assertNotNull(sottoscr_test.getPersona());
	}

}
