package it.unisalento.rest.distributori.model;

public class FeedbackModel {
	
	private Integer idPersona;
	private String testo;
	
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

}
