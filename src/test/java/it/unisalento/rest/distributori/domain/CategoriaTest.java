package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import it.unisalento.rest.distributori.factory.FactoryDao;

public class CategoriaTest {

Categoria categtest = new Categoria();
	
	@Test
	public void testCategoria() throws Exception {
		Categoria categ = new Categoria();
		assertNotNull(categ);
	}

	@Test
	public void testCategoriaString() throws Exception {
		Categoria categ = new Categoria("prova JUnit");
		assertEquals("prova JUnit",categ.getNome());
	}

	@Test
	public void testCategoriaStringSetSet() throws Exception {
		Set<Prodotto> prodottos = new HashSet<Prodotto>();
		Set<CategorieFornite> categorieFornites = new HashSet<CategorieFornite>();
		
		prodottos.add(FactoryDao.getIstance().getProdottoDao().get(1, Prodotto.class));
		prodottos.add(FactoryDao.getIstance().getProdottoDao().get(2, Prodotto.class));
		categorieFornites.add(FactoryDao.getIstance().getCategorieForniteDao().get(1, CategorieFornite.class));
		
		Categoria categ = new Categoria("prova JUnit",prodottos, categorieFornites);
		assertEquals("prova JUnit",categ.getNome());
		assertTrue(categ.getProdottos().size()==2);
		assertTrue(categ.getCategorieFornites().size()==1);
	}

	@Test
	public void testSetId() throws Exception {
		categtest.setId(0);
		assertTrue(categtest.getId()==0);
	}

	@Test
	public void testSetNome() throws Exception {
		categtest.setNome("Pippo");
		assertEquals("Pippo",categtest.getNome());
	}

	@Test
	public void testSetProdottos() throws Exception {
		Set<Prodotto> prodottos = new HashSet<Prodotto>();
		prodottos.add(FactoryDao.getIstance().getProdottoDao().get(3, Prodotto.class));
		categtest.setProdottos(prodottos);
		assertTrue(categtest.getProdottos().size()==1);
	}

	@Test
	public void testSetCategorieFornites() throws Exception {
		Set<CategorieFornite> categ_fornite = new HashSet<CategorieFornite>();
		categ_fornite.add(FactoryDao.getIstance().getCategorieForniteDao().get(6, CategorieFornite.class));
		categ_fornite.add(FactoryDao.getIstance().getCategorieForniteDao().get(7, CategorieFornite.class));
		categtest.setCategorieFornites(categ_fornite);
		assertTrue(categtest.getCategorieFornites().size()==2);
	}
}
