package it.unisalento.rest.distributori.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import it.unisalento.rest.distributori.dao.CategoriaDao;
import it.unisalento.rest.distributori.domain.Categoria;
import it.unisalento.rest.distributori.factory.FactoryDao;

public class CategoriaDaoImplTest {
	CategoriaDao dao=FactoryDao.getIstance().getCategoriaDao();
	
	@Test
	public void testCRUD() throws Exception {
		
		Integer id;
		Categoria categoria=new Categoria();
		
		//set
		categoria.setNome("Test JUnit");
		
		categoria.setId(dao.set(categoria));
		
		id=categoria.getId();
		
		assertTrue(categoria.getId()>0);
		
		//get (by ID)
		categoria=dao.get(id, Categoria.class);
		
		assertNotNull(categoria);
		assertEquals(id, categoria.getId());
		assertEquals("Test JUnit", categoria.getNome());
		
		//update
		categoria=dao.get(id, Categoria.class);
		categoria.setNome("Test update JUnit");
		dao.update(categoria);
		categoria=dao.get(id, Categoria.class);
		
		assertEquals("Test update JUnit", categoria.getNome());
		
		//delete
		categoria=dao.get(id, Categoria.class);
		dao.delete(categoria);
		categoria=dao.get(id, Categoria.class);
		
		assertEquals(null, categoria);		
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<Categoria> categorie = dao.getAll(Categoria.class);
		
		assertNotNull(categorie);
		assertTrue(categorie.size()>0);
	}
	
	@Test
	public void testGetAllSortedBy() throws Exception {//get all sorted by
		List<Categoria> categorie = dao.getAllSortedBy(Categoria.class, "nome");
		String nome1;
		String nome2;
		boolean error = false;
		for(int i=1; i<categorie.size() && !error; i++){
			nome1 = categorie.get(i-1).getNome();
			nome2 = categorie.get(i).getNome();
			if(nome1.compareTo(nome2)>0)
				error=true;
		}
		assertTrue(!error);
	}
}
