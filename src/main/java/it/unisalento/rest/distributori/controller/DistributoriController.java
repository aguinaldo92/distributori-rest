/**
 * 
 */
package it.unisalento.rest.distributori.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import it.unisalento.rest.distributori.domain.CategorieFornite;
import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.domain.ProdottiErogati;
import it.unisalento.rest.distributori.factory.FactoryDao;

/**
 * @author aguinaldo
 *
 */

public class DistributoriController implements ModelDriven<Object> {
	private BigDecimal lat;
	private BigDecimal lon;
	private Integer distanza;
	private Object model = new Object();

	public HttpHeaders index() {
		
		ArrayList<Distributore> distributoriList = new ArrayList<Distributore>();
		JSONObject distributore_JSON = new JSONObject();
		JSONArray distributori_JSON = new JSONArray();
		JSONObject ListDistributori_JSON = new JSONObject();
		Distributore distributore = new Distributore();
		
		JSONObject categoriaFornita_JSON = new JSONObject();
		JSONArray categorieFornite_JSON = new JSONArray();
		JSONObject ListCategorieFornite_JSON = new JSONObject();

		JSONObject prodottoErogato_JSON = new JSONObject();
		JSONArray prodottiErogati_JSON = new JSONArray();
		JSONObject ListProdottiErogati_JSON = new JSONObject();
		
		distributoriList =  FactoryDao.getIstance().getDistributoreDao().getDistributoriVicini(lat, lon, distanza);
		
		for (int i=0; i<distributoriList.size(); i++) {
			categorieFornite_JSON.clear();
			ListCategorieFornite_JSON.clear();			
			prodottiErogati_JSON.clear();
			ListProdottiErogati_JSON.clear();
			
			distributore =  distributoriList.get(i);
			
			//carico il distributore nel JSON
			distributore_JSON.clear();
			distributore_JSON.put("id", distributore.getId());
			distributore_JSON.put("lat", distributore.getLat());
			distributore_JSON.put("lon", distributore.getLon());
			distributore_JSON.put("posizioneEdificio", distributore.getPosizioneEdificio());
			distributore_JSON.put("indirizzo", distributore.getIndirizzo());
			
			//carico le categorie fornite per l'i-simo distributore
			for (@SuppressWarnings("unchecked")
			Iterator<CategorieFornite> iterator =  distributore.getCategorieFornites().iterator(); iterator.hasNext();) {
				CategorieFornite categoriaFornita = iterator.next();
				categoriaFornita_JSON.clear();
				if (categoriaFornita.getCategoria().getNome().compareTo("Generica") != 0){
					categoriaFornita_JSON.put("IDCategoria", categoriaFornita.getCategoria().getId());
					categoriaFornita_JSON.put("Nome", categoriaFornita.getCategoria().getNome());
				
					categorieFornite_JSON.add(categoriaFornita_JSON);
				}
			}
			ListCategorieFornite_JSON.put("CategorieFornite", categorieFornite_JSON);
			distributore_JSON.put("ListCategorieFornite", ListCategorieFornite_JSON);
			
			//carico i prodotti erogati per l'i-simo distributore
			for (@SuppressWarnings("unchecked")
			Iterator<ProdottiErogati> iterator =  distributore.getProdottiErogatis().iterator(); iterator.hasNext();) {
				ProdottiErogati prodottoErogato = iterator.next();
				prodottoErogato_JSON.clear();
				if (prodottoErogato.getProdotto().getNome().compareTo("vuoto") != 0){
					prodottoErogato_JSON.put("IDProdottoErogato", prodottoErogato.getId());
					prodottoErogato_JSON.put("IDProdotto", prodottoErogato.getProdotto().getId());
					prodottoErogato_JSON.put("Nome", prodottoErogato.getProdotto().getNome());
					prodottoErogato_JSON.put("Quantita", prodottoErogato.getQuantita());
				
					prodottiErogati_JSON.add(prodottoErogato_JSON);
				}
			}
			ListProdottiErogati_JSON.put("ProdottiErogati", prodottiErogati_JSON);
			distributore_JSON.put("ListProdottiErogati", ListProdottiErogati_JSON);
			
			distributori_JSON.add(distributore_JSON);
			
		}

		ListDistributori_JSON.put("Distributori", distributori_JSON);
		
		model = ListDistributori_JSON;
		
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

	public Object getModel() {
		return model;
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
	

}   


