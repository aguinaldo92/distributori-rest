package it.unisalento.rest.distributori.domain;
// Generated 13-apr-2017 14.28.49 by Hibernate Tools 4.3.1.Final

/**
 * FamiglieProdotto generated by hbm2java
 */
public class FamiglieProdotto implements java.io.Serializable {

	private Integer id;
	private Famiglia famiglia;
	private Prodotto prodotto;

	public FamiglieProdotto() {
	}

	public FamiglieProdotto(Famiglia famiglia, Prodotto prodotto) {
		this.famiglia = famiglia;
		this.prodotto = prodotto;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Famiglia getFamiglia() {
		return this.famiglia;
	}

	public void setFamiglia(Famiglia famiglia) {
		this.famiglia = famiglia;
	}

	public Prodotto getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

}
