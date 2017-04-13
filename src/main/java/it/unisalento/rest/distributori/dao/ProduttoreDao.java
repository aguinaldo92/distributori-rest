package it.unisalento.rest.distributori.dao;

import java.util.List;

import it.unisalento.rest.distributori.domain.Produttore;
import it.unisalento.rest.distributori.domain.Stabilimento;

public interface ProduttoreDao extends BaseDao<Produttore>{
	
	public List<Stabilimento> getStabilimentiByProduttore(int id_produttore);
		
	public List<Produttore> getAllProduttori();
}
