package it.unisalento.rest.distributori.domain;
// Generated 4-mag-2017 23.58.49 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Famiglia generated by hbm2java
 */
public class Famiglia implements java.io.Serializable {

	private Integer id;
	private String nome;
	private Set famiglieProdottos = new HashSet(0);

	public Famiglia() {
	}

	public Famiglia(String nome) {
		this.nome = nome;
	}

	public Famiglia(String nome, Set famiglieProdottos) {
		this.nome = nome;
		this.famiglieProdottos = famiglieProdottos;
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

	public Set getFamiglieProdottos() {
		return this.famiglieProdottos;
	}

	public void setFamiglieProdottos(Set famiglieProdottos) {
		this.famiglieProdottos = famiglieProdottos;
	}

}
