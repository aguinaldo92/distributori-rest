package it.unisalento.rest.distributori.dao;

import java.util.ArrayList;

import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.domain.SottoscrizioniDistributori;

public interface PersonaDao extends BaseDao<Persona>{
	
	public Persona getPersonaByCredentials(String email, String password);
	
	public boolean emailExists(String email, Integer my_ID);

	public boolean emailExists(String email);
	
	public Integer setSottoscrizioneDistributore(SottoscrizioniDistributori sottoscrizione);
	
	public ArrayList<Distributore> getSottoscrizioniByPersona(Integer idPersona);
	
}
