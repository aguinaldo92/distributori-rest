package it.unisalento.rest.distributori.model;

public class SottoscrizioneModel {

	private Integer idPersona;
	private Integer idDistributore;
	/*
	 * modality="set" - invio di una sottoscrizione nuova
	 * modality="get" - richiesta della lista di sottoscrizioni (idDistributore non viene considerato)
	 * modality="del" - cancellazione di una sottoscrizione
	 */
	private String modality;
	
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
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	
}
