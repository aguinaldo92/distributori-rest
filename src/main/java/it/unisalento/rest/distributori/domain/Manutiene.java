package it.unisalento.rest.distributori.domain;
// Generated 13-apr-2017 14.28.49 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Manutiene generated by hbm2java
 */
public class Manutiene implements java.io.Serializable {

	private Integer id;
	private Dipendente dipendente;
	private Distributore distributore;
	private Date dataInizio;
	private Date dataFine;

	public Manutiene() {
	}

	public Manutiene(Distributore distributore) {
		this.distributore = distributore;
	}

	public Manutiene(Dipendente dipendente, Distributore distributore, Date dataInizio, Date dataFine) {
		this.dipendente = dipendente;
		this.distributore = distributore;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dipendente getDipendente() {
		return this.dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public Distributore getDistributore() {
		return this.distributore;
	}

	public void setDistributore(Distributore distributore) {
		this.distributore = distributore;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

}
