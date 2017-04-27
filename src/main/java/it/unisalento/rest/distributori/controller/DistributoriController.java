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
import it.unisalento.rest.distributori.model.UtenteLocationModel;

/**
 * @author aguinaldo
 *
 */

public class DistributoriController implements ModelDriven<Object> {
	private UtenteLocationModel model = new UtenteLocationModel();
	private Object jsonModel;

	public HttpHeaders index() {

		ArrayList<Distributore> distributoriList = new ArrayList<Distributore>();
		JSONObject distributore_JSON = new JSONObject();
		JSONArray distributori_JSON = new JSONArray();
		JSONObject ListDistributori_JSON = new JSONObject();
		Distributore distributore = new Distributore();

		JSONObject categoriaFornita_JSON = new JSONObject();
		JSONArray categorieFornite_JSON = new JSONArray();

		JSONObject prodottoErogato_JSON = new JSONObject();
		JSONArray prodottiErogati_JSON = new JSONArray();
		
		distributoriList =  FactoryDao.getIstance().getDistributoreDao().getDistributoriVicini(model.getLat(), model.getLon(), model.getDistanza());

		for (int i=0; i<distributoriList.size(); i++) {
			categorieFornite_JSON.clear();			
			prodottiErogati_JSON.clear();

			distributore =  distributoriList.get(i);

			//carico il distributore nel JSON
			distributore_JSON.clear();
			distributore_JSON.put("idDistributore", distributore.getId());
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
					categoriaFornita_JSON.put("idCategoria", categoriaFornita.getCategoria().getId());
					categoriaFornita_JSON.put("nome", categoriaFornita.getCategoria().getNome());

					categorieFornite_JSON.add(categoriaFornita_JSON);
				}
			}
			//			ListCategorieFornite_JSON.put("categorieFornite", categorieFornite_JSON);
			//			distributore_JSON.put("listCategorieFornite", ListCategorieFornite_JSON);
			distributore_JSON.put("listCategorieFornite", categorieFornite_JSON);

			//carico i prodotti erogati per l'i-simo distributore
			for (@SuppressWarnings("unchecked")
			Iterator<ProdottiErogati> iterator =  distributore.getProdottiErogatis().iterator(); iterator.hasNext();) {
				ProdottiErogati prodottoErogato = iterator.next();
				prodottoErogato_JSON.clear();
				if (prodottoErogato.getProdotto().getNome().compareTo("vuoto") != 0){
					prodottoErogato_JSON.put("idProdotto", prodottoErogato.getProdotto().getId());
					prodottoErogato_JSON.put("nome", prodottoErogato.getProdotto().getNome());
					prodottoErogato_JSON.put("quantita", prodottoErogato.getQuantita());

					prodottiErogati_JSON.add(prodottoErogato_JSON);
				}
			}
			//			ListProdottiErogati_JSON.put("prodottiErogati", prodottiErogati_JSON);
			//			distributore_JSON.put("listProdottiErogati", ListProdottiErogati_JSON);
			distributore_JSON.put("listProdottiErogati", prodottiErogati_JSON);

			distributori_JSON.add(distributore_JSON);

		}

		ListDistributori_JSON.put("numero elementi", distributoriList.size());
		ListDistributori_JSON.put("distributori", distributori_JSON);

		jsonModel = ListDistributori_JSON;

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
		if (jsonModel != null )
			return jsonModel; 

		return  model;
	}



}   


