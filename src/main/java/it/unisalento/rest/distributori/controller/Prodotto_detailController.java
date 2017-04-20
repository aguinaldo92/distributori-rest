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
		
		prodotto_JSON.put("idProdotto", prodotto.getId());
		prodotto_JSON.put("foto", prodotto.getFoto().replaceAll("\\.", "_256sizes."));
		prodotto_JSON.put("nome", prodotto.getNome());
		prodotto_JSON.put("descrizione", prodotto.getDescrizione());
		prodotto_JSON.put("prezzo", prodotto.getPrezzo());
		prodotto_JSON.put("sconto", prodotto.getScontoUtenti());
		prodotto_JSON.put("ingredienti",prodotto.getIngredienti());
		prodotto_JSON.put("preparazione", prodotto.getPreparazione());
		produttore_JSON.put("nome", prodotto.getStabilimento().getProduttore().getNome());
		produttore_JSON.put("sede", prodotto.getStabilimento().getProduttore().getSede());
		stabilimento_JSON.put("citta", prodotto.getStabilimento().getCitta());
		stabilimento_JSON.put("provincia", prodotto.getStabilimento().getProvincia());
		produttore_JSON.put("stabilimento", stabilimento_JSON);
		prodotto_JSON.put("produttore", produttore_JSON);
		
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
