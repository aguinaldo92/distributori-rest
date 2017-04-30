package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unisalento.rest.distributori.factory.FactoryDao;

public class CategorieForniteTest {

	@Test
	public void testCategorieForniteCategoriaDistributore() throws Exception {
		CategorieFornite categs = new CategorieFornite(new Categoria("Esempio"), new Distributore());
		assertNotNull(categs);
		assertEquals("Esempio",categs.getCategoria().getNome());
	}

}
