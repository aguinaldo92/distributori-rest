package it.unisalento.rest.distributori.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import it.unisalento.rest.distributori.dao.ProduttoreDao;
import it.unisalento.rest.distributori.domain.Produttore;
import it.unisalento.rest.distributori.factory.FactoryDao;

public class ProduttoreDaoImplTest {

	ProduttoreDao dao = FactoryDao.getIstance().getProduttoreDao();
	
	@Test
	public void testCRUD() throws Exception {
		
		Integer id;
		Produttore produttore=new Produttore();
		
		//set
		produttore.setNome("JUnit Test");
		produttore.setSede("prova");
		
		produttore.setId(dao.set(produttore));
		
		id=produttore.getId();
		
		assertTrue(produttore.getId()>0);
		
		//get (by ID)
		produttore=dao.get(id, Produttore.class);
		
		assertNotNull(produttore);
		assertEquals(id, produttore.getId());
		assertEquals("JUnit Test", produttore.getNome());
		
		//update
		produttore=dao.get(id, Produttore.class);
		produttore.setNome("JUnit Test updated");
		dao.update(produttore);
		produttore=dao.get(id, Produttore.class);
		
		assertEquals("JUnit Test updated", produttore.getNome());
		
		//delete
		produttore=dao.get(id, Produttore.class);
		dao.delete(produttore);
		produttore=dao.get(id, Produttore.class);
		
		assertEquals(null, produttore);		
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<Produttore> produttori = dao.getAll(Produttore.class);
		
		assertNotNull(produttori);
		assertTrue(produttori.size()>0);
	}

	@Test
	public void testGetAllSortedBy() throws Exception {
		List<Produttore> produttori = dao.getAllSortedBy(Produttore.class, "sede");
		String sede1;
		String sede2;
		boolean error = false;
		for(int i=1; i<produttori.size() && !error; i++){
			sede1 = produttori.get(i-1).getSede();
			sede2 = produttori.get(i).getSede();
			if(sede1.compareToIgnoreCase(sede2)>0)
				error=true;
		}
		assertTrue(!error);
	}
}
