package it.unisalento.rest.distributori.factory;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import it.unisalento.rest.distributori.dao.*;


public class FactoryDaoTest {

	FactoryDao istance = new FactoryDao();
	
	@Test
	public void testGetIstance() throws Exception {
		assertNotNull(FactoryDao.getIstance());
	}

	@Test
	public void testGetPersonaDao() throws Exception {
		PersonaDao dao = istance.getPersonaDao();
		assertNotNull(dao);
	}

	@Test
	public void testGetProdottoDao() throws Exception {
		ProdottoDao dao = istance.getProdottoDao();
		assertNotNull(dao);
	}

	@Test
	public void testGetCategoriaDao() throws Exception {
		CategoriaDao dao = istance.getCategoriaDao();
		assertNotNull(dao);
	}

	@Test
	public void testGetDistributoreDao() throws Exception {
		DistributoreDao dao = istance.getDistributoreDao();
		assertNotNull(dao);
	}

	@Test
	public void testGetCategorieForniteDao() throws Exception {
		CategorieForniteDao dao = istance.getCategorieForniteDao();
		assertNotNull(dao);
	}

	@Test
	public void testGetProdottiErogatiDao() throws Exception {
		ProdottiErogatiDao dao = istance.getProdottiErogatiDao();
		assertNotNull(dao);
	}

	@Test
	public void testGetFeedbackDao() throws Exception {
		FeedbackDao dao = istance.getFeedbackDao();
		assertNotNull(dao);
	}

	@Test
	public void testGetAcquistaDao() throws Exception {
		AcquistaDao dao = istance.getAcquistaDao();
		assertNotNull(dao);
	}

	@Test
	public void testGetStabilimentoDao() throws Exception {
		StabilimentoDao dao = istance.getStabilimentoDao();
		assertNotNull(dao);
	}

}
