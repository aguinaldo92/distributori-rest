package it.unisalento.rest.distributori.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import it.unisalento.rest.distributori.dao.FeedbackDao;
import it.unisalento.rest.distributori.domain.Feedback;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.factory.FactoryDao;

public class FeedbackDaoImplTest {
	
	FeedbackDao dao = FactoryDao.getIstance().getFeedbackDao();
	
	@Test
	public void testCRUD() throws Exception {
		
		Integer id;
		Feedback feedback=new Feedback();
		
		//set
		Byte letto=0;
		Persona persona = FactoryDao.getIstance().getPersonaDao().get(10, Persona.class);
		feedback.setData(new Date());
		feedback.setLetto(letto);
		feedback.setTesto("testo di prova JUnit");
		feedback.setPersona(persona);
		feedback.setId(dao.set(feedback));
		
		id=feedback.getId();
		
		assertTrue(feedback.getId()>0);
		
		//get (by ID)
		feedback=dao.get(id, Feedback.class);
		
		assertNotNull(feedback);
		assertEquals(id, feedback.getId());
		
		//update
		feedback=dao.get(id, Feedback.class);
		feedback.setTesto("testo di prova updated JUnit");
		dao.update(feedback);
		feedback=dao.get(id, Feedback.class);
		
		assertEquals("testo di prova updated JUnit", feedback.getTesto());
		
		//delete
		feedback=dao.get(id, Feedback.class);
		dao.delete(feedback);
		feedback=dao.get(id, Feedback.class);
		
		assertEquals(null, feedback);
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<Feedback> feedbacks = dao.getAll(Feedback.class);
		
		assertNotNull(feedbacks);
		assertTrue(feedbacks.size()>=0);
	}

	@Test
	public void testGetAllSortedBy() throws Exception {
		List<Feedback> feedbacks = dao.getAllSortedBy(Feedback.class, "letto");
		Byte letto1;
		Byte letto2;
		boolean error = false;
		for(int i=1; i<feedbacks.size() && !error; i++){
			letto1 = feedbacks.get(i-1).getLetto();
			letto2 = feedbacks.get(i).getLetto();
			if(letto1>letto2)
				error=true;
		}
		assertTrue(!error);
	}


}
