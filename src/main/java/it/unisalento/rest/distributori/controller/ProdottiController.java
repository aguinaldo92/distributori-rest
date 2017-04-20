package it.unisalento.rest.distributori.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Prodotto;
import it.unisalento.rest.distributori.factory.FactoryDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProdottiController implements ModelDriven<Object> {
	
	private Object model = new Object();
	
	public HttpHeaders index(){
		
		ArrayList<Prodotto> prodottiList = new ArrayList<Prodotto>();
		JSONObject prodotto_JSON = new JSONObject();
		JSONArray prodotti_JSON = new JSONArray();
		JSONObject ListProdotti_JSON = new JSONObject();
		Prodotto prodotto = new Prodotto();
		
		prodottiList = (ArrayList<Prodotto>) FactoryDao.getIstance().getProdottoDao().getAllSortedBy(Prodotto.class, "nome");
		
		//carico tutte i prodotti nel JSON
		for (Iterator<Prodotto> iterator =  prodottiList.iterator(); iterator.hasNext();) {
			prodotto = iterator.next();
			prodotto_JSON.clear();
			if (prodotto.getNome().compareTo("vuoto") != 0){
				prodotto_JSON.put("idProdotto", prodotto.getId());
				prodotto_JSON.put("nome", prodotto.getNome());
			
				prodotti_JSON.add(prodotto_JSON);
			}
		}
		
		ListProdotti_JSON.put("prodotti", prodotti_JSON);
		
		model = ListProdotti_JSON;
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	@Override
	public Object getModel() {
		return model;
	}

}
