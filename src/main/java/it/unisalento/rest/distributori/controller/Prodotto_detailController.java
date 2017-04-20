package it.unisalento.rest.distributori.controller;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Prodotto;
import it.unisalento.rest.distributori.factory.FactoryDao;
import net.sf.json.JSONObject;

public class Prodotto_detailController implements ModelDriven<Object> {
	
	private Object model = new Object();
	private Integer idProdotto;
	
	public HttpHeaders index(){
		
		JSONObject prodotto_JSON = new JSONObject();
		JSONObject produttore_JSON = new JSONObject();
		JSONObject stabilimento_JSON = new JSONObject();
		
		Prodotto prodotto = FactoryDao.getIstance().getProdottoDao().get(idProdotto, Prodotto.class);
		
		prodotto_JSON.put("IdProdotto", prodotto.getId());
		prodotto_JSON.put("Foto", prodotto.getFoto());
		prodotto_JSON.put("Nome", prodotto.getNome());
		prodotto_JSON.put("Descrizione", prodotto.getDescrizione());
		prodotto_JSON.put("Prezzo", prodotto.getPrezzo());
		prodotto_JSON.put("Sconto", prodotto.getScontoUtenti());
		prodotto_JSON.put("Ingredienti",prodotto.getIngredienti());
		prodotto_JSON.put("Preparazione", prodotto.getPreparazione());
		produttore_JSON.put("Nome", prodotto.getStabilimento().getProduttore().getNome());
		produttore_JSON.put("Sede", prodotto.getStabilimento().getProduttore().getSede());
		stabilimento_JSON.put("Citta", prodotto.getStabilimento().getCitta());
		stabilimento_JSON.put("Provincia", prodotto.getStabilimento().getProvincia());
		produttore_JSON.put("Stabilimento", stabilimento_JSON);
		prodotto_JSON.put("Produttore", produttore_JSON);
		
		model = prodotto_JSON;
		
		
		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public Object getModel() {
		return model;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}

}
