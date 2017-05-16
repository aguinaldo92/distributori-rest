package it.unisalento.rest.distributori.domain;
// Generated 4-mag-2017 23.58.07 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona implements java.io.Serializable {

	private Integer id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private int ruolo;
	private Set feedbacks = new HashSet(0);
	private Set acquistas = new HashSet(0);

	public Persona() {
	}

	public Persona(String email, String password, int ruolo) {
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}

	public Persona(String nome, String cognome, String email, String password, int ruolo, Set feedbacks,
			Set acquistas) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
		this.feedbacks = feedbacks;
		this.acquistas = acquistas;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}

	public Set getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Set getAcquistas() {
		return this.acquistas;
	}

	public void setAcquistas(Set acquistas) {
		this.acquistas = acquistas;
	}

}
