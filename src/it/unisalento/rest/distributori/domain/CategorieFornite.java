package it.unisalento.rest.distributori.domain;
// Generated 4-mag-2017 23.58.07 by Hibernate Tools 4.3.1.Final

/**
 * CategorieFornite generated by hbm2java
 */
public class CategorieFornite implements java.io.Serializable {

	private Integer id;
	private Categoria categoria;
	private Distributore distributore;

	public CategorieFornite() {
	}

	public CategorieFornite(Categoria categoria, Distributore distributore) {
		this.categoria = categoria;
		this.distributore = distributore;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Distributore getDistributore() {
		return this.distributore;
	}

	public void setDistributore(Distributore distributore) {
		this.distributore = distributore;
	}

}
