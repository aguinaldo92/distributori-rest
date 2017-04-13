package it.unisalento.rest.distributori.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DistributoreModel {
	private Integer id;
	private BigDecimal lat;
	private BigDecimal lon;
	private String posizioneEdificio;
	private String indirizzo;
	private ArrayList<?> categorieFornite;
	private ArrayList<?> prodottiForniti;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLon() {
		return lon;
	}
	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}
	public String getPosizioneEdificio() {
		return posizioneEdificio;
	}
	public void setPosizioneEdificio(String posizioneEdificio) {
		this.posizioneEdificio = posizioneEdificio;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public ArrayList<?> getCategorieFornite() {
		return categorieFornite;
	}
	public void setCategorieFornite(ArrayList<?> categorieFornite) {
		this.categorieFornite = categorieFornite;
	}
	public ArrayList<?> getProdottiForniti() {
		return prodottiForniti;
	}
	public void setProdottiForniti(ArrayList<?> prodottiForniti) {
		this.prodottiForniti = prodottiForniti;
	}
	
	

}
