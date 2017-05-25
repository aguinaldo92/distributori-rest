package it.unisalento.rest.distributori.model;

import java.math.BigDecimal;

public class AcquistaModel {
	
	private Integer idProdottoErogato;
	private Integer quantita;
	private BigDecimal totale_spesa;
	private Integer idPersona;//se -1 l'acquisto viene registrato con ID_Persona=NULL sul DB
	private Integer idDistributore;
	private Integer idProdotto;
	
	
	public Integer getIdProdottoErogato() {
		return idProdottoErogato;
	}
	public void setIdProdottoErogato(Integer idProdottoErogato) {
		this.idProdottoErogato = idProdottoErogato;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public BigDecimal getTotale_spesa() {
		return totale_spesa;
	}
	public void setTotale_spesa(BigDecimal totale_spesa) {
		this.totale_spesa = totale_spesa;
	}
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
	public Integer getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}
	
}
