package it.unisalento.rest.distributori.model;

import java.math.BigDecimal;

public class UtenteLocationModel {
	private BigDecimal lat;
	private BigDecimal lon;
	private Integer distanza;
	
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
	public Integer getDistanza() {
		return distanza;
	}
	public void setDistanza(Integer distanza) {
		this.distanza = distanza;
	}
	
	

	

}
