package it.unisalento.rest.distributori.model;

import java.math.BigDecimal;

public class UtenteLocationModel {
	private BigDecimal lat;
	private BigDecimal lon;
	private Integer distanza;
	
	public UtenteLocationModel(String lat_p,String lon_p, String distanza_p){
		setLat(lat_p);
		setLon(lon_p);
		setDistanza(distanza_p);
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = new BigDecimal(lat);
	}
	public BigDecimal getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = new BigDecimal(lon);
	}

	public Integer getDistanza() {
		return distanza;
	}
	public void setDistanza(String distanza) {
		this.distanza = new Integer(distanza);
	}
	
	

}
