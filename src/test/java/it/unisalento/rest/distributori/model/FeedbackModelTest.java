package it.unisalento.rest.distributori.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FeedbackModelTest {

	FeedbackModel fbtest = new FeedbackModel();
	
	@Test
	public void testSetTesto() throws Exception {
		fbtest.setTesto("feedback");
		assertEquals("feedback", fbtest.getTesto());
	}

	@Test
	public void testSetIdPersona() throws Exception {
		fbtest.setIdPersona(0);
		assertTrue(fbtest.getIdPersona()==0);
	}

}
