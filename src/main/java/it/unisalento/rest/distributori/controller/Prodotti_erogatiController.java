package it.unisalento.rest.distributori.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.ProdottiErogati;
import it.unisalento.rest.distributori.factory.FactoryDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Prodotti_erogatiController implements ModelDriven<Object> {
	
	private Object model = new Object();
	private Integer idDistributore;
	
	public HttpHeaders index(){
		
		ArrayList<ProdottiErogati> prodottiErogatiList = new ArrayList<ProdottiErogati>();
		JSONObject prodottoErogato_JSON = new JSONObject();
		JSONArray prodottiErogati_JSON = new JSONArray();
		JSONObject ListProdotti_JSON = new JSONObject();
		ProdottiErogati prodottoErogato = new ProdottiErogati();
		
		prodottiErogatiList = FactoryDao.getIstance().getProdottiErogatiDao().getProdottiErogatiByDistributoreSortedByScaffalePosto(idDistributore);
		
		
		//carico tutte i prodotti nel JSON
		for (Iterator<ProdottiErogati> iterator =  prodottiErogatiList.iterator(); iterator.hasNext();) {
			prodottoErogato = iterator.next();
			prodottoErogato_JSON.clear();
			if (prodottoErogato.getProdotto().getNome().compareTo("vuoto") != 0){
				prodottoErogato_JSON.put("IdProdottoErogato", prodottoErogato.getId());
				prodottoErogato_JSON.put("Scaffale", prodottoErogato.getScaffale());
				prodottoErogato_JSON.put("Posto", prodottoErogato.getPosto());
				prodottoErogato_JSON.put("Quantita", prodottoErogato.getQuantita());
				prodottoErogato_JSON.put("IdProdotto", prodottoErogato.getProdotto().getId());
				prodottoErogato_JSON.put("Nome", prodottoErogato.getProdotto().getNome());
				prodottoErogato_JSON.put("Prezzo", prodottoErogato.getProdotto().getPrezzo());
				prodottoErogato_JSON.put("Sconto", prodottoErogato.getProdotto().getScontoUtenti());
				prodottoErogato_JSON.put("Foto", prodottoErogato.getProdotto().getFoto());
				prodottoErogato_JSON.put("Produttore", prodottoErogato.getProdotto().getStabilimento().getProduttore().getNome());
			
				prodottiErogati_JSON.add(prodottoErogato_JSON);
			}
		}
		
		ListProdotti_JSON.put("ProdottiErogati", prodottiErogati_JSON);
		
		model = ListProdotti_JSON;
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	@Override
	public Object getModel() {
		return model;
	}

	public void setIdDistributore(Integer idDistributore) {
		this.idDistributore = idDistributore;
	}

	public Integer getIdDistributore() {
		return idDistributore;
	}
}
