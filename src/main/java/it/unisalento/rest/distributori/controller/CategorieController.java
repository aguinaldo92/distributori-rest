package it.unisalento.rest.distributori.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import it.unisalento.rest.distributori.domain.Categoria;
import it.unisalento.rest.distributori.factory.FactoryDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CategorieController implements ModelDriven<Object> {
	
	private Object model = new Object();
	
	public HttpHeaders index(){
		
		ArrayList<Categoria> categorieList = new ArrayList<Categoria>();
		JSONObject categoria_JSON = new JSONObject();
		JSONArray categorie_JSON = new JSONArray();
		JSONObject ListCategorie_JSON = new JSONObject();
		Categoria categoria = new Categoria();
		
		categorieList = (ArrayList<Categoria>) FactoryDao.getIstance().getCategoriaDao().getAllSortedBy(Categoria.class, "nome");
		
		//carico tutte le categorie nel JSON
		for (Iterator<Categoria> iterator =  categorieList.iterator(); iterator.hasNext();) {
			categoria = iterator.next();
			categoria_JSON.clear();
			if (categoria.getNome().compareTo("Generica") != 0){
				categoria_JSON.put("IdCategoria", categoria.getId());
				categoria_JSON.put("Nome", categoria.getNome());
			
				categorie_JSON.add(categoria_JSON);
			}
		}
		
		ListCategorie_JSON.put("Categorie", categorie_JSON);
		
		model = ListCategorie_JSON;
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	@Override
	public Object getModel() {
		return model;
	}

}
