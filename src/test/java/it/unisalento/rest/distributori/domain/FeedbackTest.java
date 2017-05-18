package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class FeedbackTest {

	Feedback fbtest = new Feedback();
	
	@Test
	public void testFeedback() throws Exception {
		Feedback fb = new Feedback();
		assertNotNull(fb);
	}

	@Test
	public void testFeedbackString() throws Exception {
		Feedback fb = new Feedback("Eclipse e Struts mai più");
		assertEquals("Eclipse e Struts mai più", fb.getTesto());
	}

	@Test
	public void testFeedbackPersonaStringDateByte() throws Exception {
		Feedback fb = new Feedback(new Persona(), "Esempio", new Date(), (byte)0);
		assertNotNull(fb);
		assertTrue(fb.getLetto()==0);
		assertNotNull(fb.getPersona());
		assertNotNull(fb.getData());
		assertEquals("Esempio", fb.getTesto());
	}

	@Test
	public void testSetId() throws Exception {
		fbtest.setId(0);
		assertTrue(fbtest.getId()==0);
	}

	@Test
	public void testSetPersona() throws Exception {
		fbtest.setPersona(new Persona());
		assertNotNull(fbtest.getPersona());
	}

	@Test
	public void testSetTesto() throws Exception {
		fbtest.setTesto("Mai più");
		assertEquals("Mai più", fbtest.getTesto());
	}

	@Test
	public void testSetData() throws Exception {
		Date data = new Date();
		fbtest.setData(data);
		assertEquals(data, fbtest.getData());
	}

	@Test
	public void testSetLetto() throws Exception {
		byte letto = 0;
		fbtest.setLetto(letto);
		assertTrue(fbtest.getLetto()==letto);
	}

}
