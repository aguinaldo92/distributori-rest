package it.unisalento.rest.distributori.model;

public class SottoscrizioneModel {

	private Integer idPersona;
	private Integer idDistributore;//se pari a -1, SottoscrizioniController restituisce la lista delle sottoscrizioni di idPersona
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public Integer getIdDistributore() {
		return idDistributore;
	}
	public void setIdDistributore(Integer idDistributore) {
		this.idDistributore = idDistributore;
	}
	
}
