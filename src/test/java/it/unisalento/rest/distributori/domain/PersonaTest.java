package it.unisalento.rest.distributori.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PersonaTest {


	Persona personatest = new Persona();
	
	@Test
	public void testPersona() throws Exception {
		Persona persona = new Persona();
		assertNotNull(persona);
	}

	@Test
	public void testPersonaStringStringInt() throws Exception {
		Persona persona = new Persona("mail", "password", 0);
		assertNotNull(persona);
		assertEquals("mail",persona.getEmail());
		assertEquals("password", persona.getPassword());
		assertTrue(persona.getRuolo()==0);
	}

	@Test
	public void testSetId() throws Exception {
		personatest.setId(1);
		assertTrue(personatest.getId()==1);
	}

	@Test
	public void testSetNome() throws Exception {
		personatest.setNome("Pippo");
		assertEquals("Pippo",personatest.getNome());
	}

	@Test
	public void testSetCognome() throws Exception {
		personatest.setCognome("Inzaghi");
		assertEquals("Inzaghi",personatest.getCognome());
	}

	@Test
	public void testSetEmail() throws Exception {
		personatest.setEmail("Email");
		assertEquals("Email",personatest.getEmail());
	}

	@Test
	public void testSetPassword() throws Exception {
		personatest.setPassword("Password");
		assertEquals("Password",personatest.getPassword());
	}

	@Test
	public void testSetRuolo() throws Exception {
		personatest.setRuolo(1);
		assertTrue(personatest.getRuolo()==1);
	}

	@Test
	public void testSetFeedbacks() throws Exception {
		Set<Feedback> fbs = new HashSet<Feedback>();
		fbs.add(new Feedback("testo1"));
		fbs.add(new Feedback("testo2"));
		personatest.setFeedbacks(fbs);
		assertTrue(personatest.getFeedbacks().size()==2);
	}

	@Test
	public void testSetAcquistas() throws Exception {
		Set<Acquista> acquisti = new HashSet<Acquista>();
		acquisti.add(new Acquista());
		acquisti.add(new Acquista());
		personatest.setAcquistas(acquisti);
		assertTrue(personatest.getAcquistas().size()==2);
	}
}
