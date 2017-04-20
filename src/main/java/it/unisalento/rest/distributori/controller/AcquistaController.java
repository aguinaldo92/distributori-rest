package it.unisalento.rest.distributori.controller;

import java.util.Date;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Acquista;
import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.domain.ProdottiErogati;
import it.unisalento.rest.distributori.domain.Prodotto;
import it.unisalento.rest.distributori.factory.FactoryDao;
import it.unisalento.rest.distributori.model.AcquistaModel;
import net.sf.json.JSONObject;

public class AcquistaController  implements ModelDriven<Object> {
	
	private AcquistaModel model = new AcquistaModel();
	private JSONObject result;
	
	public HttpHeaders create(){
		
		Persona persona = FactoryDao.getIstance().getPersonaDao().get(model.getIdPersona(), Persona.class);
		Distributore distributore = FactoryDao.getIstance().getDistributoreDao().get(model.getIdDistributore(), Distributore.class);
		Prodotto prodotto = FactoryDao.getIstance().getProdottoDao().get(model.getIdProdotto(), Prodotto.class);
		
		Acquista acquisto = new Acquista();
		acquisto.setData(new Date());
		acquisto.setDistributore(distributore);
		acquisto.setPersona(persona);
		acquisto.setProdotto(prodotto);
		acquisto.setQuantita(model.getQuantita());
		acquisto.setTotaleSpesa(model.getTotale_spesa());
		
		//salvataggio acquisto nel DB
		acquisto.setId(FactoryDao.getIstance().getAcquistaDao().set(acquisto));
		
		//aggiornamento quantità del prodotto acquistato nel DB
		ProdottiErogati prodotto_erogato = FactoryDao.getIstance().getProdottiErogatiDao().get(model.getIdProdottoErogato(), ProdottiErogati.class);
		prodotto_erogato.setQuantita(prodotto_erogato.getQuantita() - model.getQuantita());
		FactoryDao.getIstance().getProdottiErogatiDao().update(prodotto_erogato);
		
		result = new JSONObject();
		result.put("result", true);
		result.put("id", acquisto.getId());
		result.put("quantità aggiornata", prodotto_erogato.getQuantita());
		
		return new DefaultHttpHeaders("create").disableCaching();
	}

	@Override
	public Object getModel() {
		if ( result != null)
			return result;
		return model;
	}
	
}
