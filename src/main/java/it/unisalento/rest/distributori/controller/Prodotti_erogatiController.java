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
				prodottoErogato_JSON.put("idProdottoErogato", prodottoErogato.getId());
				prodottoErogato_JSON.put("scaffale", prodottoErogato.getScaffale());
				prodottoErogato_JSON.put("posto", prodottoErogato.getPosto());
				prodottoErogato_JSON.put("quantita", prodottoErogato.getQuantita());
				prodottoErogato_JSON.put("idProdotto", prodottoErogato.getProdotto().getId());
				prodottoErogato_JSON.put("nome", prodottoErogato.getProdotto().getNome());
				prodottoErogato_JSON.put("prezzo", prodottoErogato.getProdotto().getPrezzo());
				prodottoErogato_JSON.put("sconto", prodottoErogato.getProdotto().getScontoUtenti());
				prodottoErogato_JSON.put("foto", prodottoErogato.getProdotto().getFoto().replaceAll("\\.", "_64sizes."));
				prodottoErogato_JSON.put("produttore", prodottoErogato.getProdotto().getStabilimento().getProduttore().getNome());
			
				prodottiErogati_JSON.add(prodottoErogato_JSON);
			}
		}
		
		ListProdotti_JSON.put("prodottiErogati", prodottiErogati_JSON);
		
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
