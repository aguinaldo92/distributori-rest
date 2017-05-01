package it.unisalento.rest.distributori.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import it.unisalento.rest.distributori.dao.ProdottoDao;
import it.unisalento.rest.distributori.domain.Categoria;
import it.unisalento.rest.distributori.domain.Prodotto;
import it.unisalento.rest.distributori.domain.Stabilimento;
import it.unisalento.rest.distributori.factory.FactoryDao;

public class ProdottoDaoImplTest {
	ProdottoDao dao = FactoryDao.getIstance().getProdottoDao();
	
	@Test
	public void testCRUD() throws Exception {
		
		Integer id;
		Prodotto prodotto=new Prodotto();
		
		//set
		prodotto.setFoto("foto JUnit");
		prodotto.setIngredienti("basta un poco di zucchero");
		prodotto.setNome("prova");
		prodotto.setPreparazione("preparazione JUnit");
		prodotto.setPrezzo(BigDecimal.valueOf(0));
		prodotto.setScontoUtenti(BigDecimal.valueOf(0.10));
		prodotto.setStabilimento(FactoryDao.getIstance().getStabilimentoDao().get(1, Stabilimento.class));
		prodotto.setCategoria(FactoryDao.getIstance().getCategoriaDao().get(1, Categoria.class));
		
		prodotto.setId(dao.set(prodotto));
		id=prodotto.getId();
		
		assertTrue(prodotto.getId()>0);
		
		//get (by ID)
		prodotto=dao.get(id, Prodotto.class);
		
		assertNotNull(prodotto);
		assertEquals(id, prodotto.getId());
		
		//update
		prodotto=dao.get(id, Prodotto.class);
		prodotto.setNome("prova updated");
		dao.update(prodotto);
		prodotto=dao.get(id, Prodotto.class);
		
		assertEquals("prova updated", prodotto.getNome());
		
		//delete
		prodotto=dao.get(id, Prodotto.class);
		dao.delete(prodotto);
		prodotto=dao.get(id, Prodotto.class);
		
		assertEquals(null, prodotto);
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<Prodotto> prodotti = dao.getAll(Prodotto.class);
		
		assertNotNull(prodotti);
		assertTrue(prodotti.size()>0);
	}

	@Test
	public void testGetAllSortedBy() throws Exception {
		List<Prodotto> prodotti = dao.getAllSortedBy(Prodotto.class, "descrizione");
		String descr1;
		String descr2;
		boolean error = false;
		for(int i=1; i<prodotti.size() && !error; i++){
			descr1 = prodotti.get(i-1).getDescrizione();
			descr2 = prodotti.get(i).getDescrizione();
			if(descr1.compareToIgnoreCase(descr2)>0)
				error=true;
		}
		assertTrue(!error);
	}
}
