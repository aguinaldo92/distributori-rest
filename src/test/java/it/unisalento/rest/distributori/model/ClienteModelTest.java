package it.unisalento.rest.distributori.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteModelTest {

	ClienteModel clientest = new ClienteModel();
	
	@Test
	public void testSetEmail() throws Exception {
		clientest.setEmail("JUnit@junit.it");
		assertEquals("JUnit@junit.it",clientest.getEmail());
	}

	@Test
	public void testSetPassword() throws Exception {
		clientest.setPassword("JUnit");
		assertEquals("JUnit",clientest.getPassword());
	}

	@Test
	public void testSetNome() throws Exception {
		clientest.setNome("JUnit");
		assertEquals("JUnit",clientest.getNome());
	}

	@Test
	public void testSetCognome() throws Exception {
		clientest.setCognome("Muscatello");
		assertEquals("Muscatello",clientest.getCognome());
	}

	@Test
	public void testSetId() throws Exception {
		clientest.setId(0);
		assertTrue(clientest.getId()==0);
	}

}
