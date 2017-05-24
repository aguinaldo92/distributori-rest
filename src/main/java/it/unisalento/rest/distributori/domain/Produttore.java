package it.unisalento.rest.distributori.domain;
// Generated 24-mag-2017 22.56.53 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Produttore generated by hbm2java
 */
public class Produttore implements java.io.Serializable {

	private Integer id;
	private String nome;
	private String sede;
	private Set stabilimentos = new HashSet(0);

	public Produttore() {
	}

	public Produttore(String nome, String sede, Set stabilimentos) {
		this.nome = nome;
		this.sede = sede;
		this.stabilimentos = stabilimentos;
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

	public String getSede() {
		return this.sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Set getStabilimentos() {
		return this.stabilimentos;
	}

	public void setStabilimentos(Set stabilimentos) {
		this.stabilimentos = stabilimentos;
	}

}
