package it.unisalento.rest.distributori.daoimpl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import it.unisalento.rest.distributori.dao.AcquistaDao;
import it.unisalento.rest.distributori.domain.Acquista;
import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.domain.Prodotto;
import it.unisalento.rest.distributori.factory.FactoryDao;

public class AcquistaDaoImplTest {

	AcquistaDao dao = FactoryDao.getIstance().getAcquistaDao();
	
	@Test
	public void testCRUD() throws Exception {
		
		Integer id;
		Acquista acq=new Acquista();
		
		acq.setData(new Date());
		acq.setDistributore(FactoryDao.getIstance().getDistributoreDao().get(3, Distributore.class));
		acq.setPersona(FactoryDao.getIstance().getPersonaDao().get(1, Persona.class));
		acq.setProdotto(FactoryDao.getIstance().getProdottoDao().get(3, Prodotto.class));
		acq.setQuantita(10);
		acq.setTotaleSpesa(BigDecimal.valueOf(12));
		
		acq.setId(dao.set(acq));
		
		id=acq.getId();
		
		assertTrue(acq.getId()>0);
		
		//get (by ID)
		acq=dao.get(id, Acquista.class);
		
		assertNotNull(acq);
		assertEquals(id, acq.getId());
		assertTrue(acq.getQuantita()==10);
		
		//update
		acq=dao.get(id, Acquista.class);
		acq.setQuantita(5);
		dao.update(acq);
		acq=dao.get(id, Acquista.class);
		
		assertTrue(acq.getQuantita()==5);
		
		//delete
		acq=dao.get(id, Acquista.class);
		dao.delete(acq);
		acq=dao.get(id, Acquista.class);
		
		assertNull(acq);		
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<Acquista> acquisti = dao.getAll(Acquista.class);
		
		assertNotNull(acquisti);
	}
	
	@Test
	public void testGetAllSortedBy(){
		List<Acquista> acquisti = dao.getAllSortedBy(Acquista.class, "data");
		Date data1;
		Date data2;
		boolean error = false;
		for(int i=1; i<acquisti.size() && !error; i++){
			data1 = acquisti.get(i-1).getData();
			data2 = acquisti.get(i).getData();
			if(data1.compareTo(data2)>0)
				error=true;
		}
		assertTrue(!error);
	}

}
