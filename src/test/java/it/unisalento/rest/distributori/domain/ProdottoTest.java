package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProdottoTest {

	@Test
	public void testProdotto(){
		Prodotto prodotto = new Prodotto();
		assertNotNull(prodotto);
	}

}
