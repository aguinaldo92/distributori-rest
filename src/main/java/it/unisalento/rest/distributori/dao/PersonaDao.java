package it.unisalento.rest.distributori.dao;

import it.unisalento.rest.distributori.domain.Persona;

public interface PersonaDao extends BaseDao<Persona>{
	
	public Persona getPersonaByCredentials(String email, String password);
	
	public boolean emailExists(String email, Integer my_ID);

	boolean emailExists(String email);
	
}
