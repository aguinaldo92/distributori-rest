/**
 * 
 */
package it.unisalento.rest.distributori.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.model.DistributoreModel;
import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.factory.FactoryDao;

/**
 * @author aguinaldo
 *
 */

public class DistributoriController implements ModelDriven<Object> {
	private BigDecimal lat;
	private BigDecimal lon;
	private Integer distanza;
	private ArrayList<DistributoreModel> model = new ArrayList<DistributoreModel>(); 

	public HttpHeaders index() {
		model =  (ArrayList<DistributoreModel>) FactoryDao.getIstance().getDistributoreDao().getDistributoriVicini(lat, lon, distanza);
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
    // Handles /orders/{id} GET requests
    public HttpHeaders show() {
        return new DefaultHttpHeaders("show");
            
    }
	
	public String add(){
		//Integer empId = Integer.parseInt(id);
		//Employee emp = new Employee(empId,"Ramesh", "PQR");
		//model = emp;
		return "SUCCESS";
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

	public Integer getDistanza() {
		return distanza;
	}

	public void setDistanza(Integer distanza) {
		this.distanza = distanza;
	}

	public Object getModel() {
		return model;
	}
	

}   


