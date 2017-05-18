package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategorieForniteTest {

	@Test
	public void testCategorieForniteCategoriaDistributore() throws Exception {
		CategorieFornite categs = new CategorieFornite(new Categoria("Esempio"), new Distributore());
		assertNotNull(categs);
		assertEquals("Esempio",categs.getCategoria().getNome());
	}

	@Test
	public void testSetCategoria() throws Exception {
		CategorieFornite categs = new CategorieFornite();
		categs.setCategoria(new Categoria("Nome"));
		assertNotNull(categs.getCategoria());
		assertEquals("Nome",categs.getCategoria().getNome());
	}

	@Test
	public void testSetDistributore() throws Exception {
		CategorieFornite categs = new CategorieFornite();
		categs.setDistributore(new Distributore());
		assertNotNull(categs.getDistributore());
	}

	@Test
	public void testSetId() throws Exception {
		CategorieFornite categs = new CategorieFornite();
		categs.setId(0);
		assertTrue(categs.getId()==0);
	}

}
