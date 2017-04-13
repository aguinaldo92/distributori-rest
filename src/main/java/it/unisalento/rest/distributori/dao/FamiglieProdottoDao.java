package it.unisalento.rest.distributori.dao;

import java.util.List;

import it.unisalento.rest.distributori.domain.FamiglieProdotto;

public interface FamiglieProdottoDao extends BaseDao<FamiglieProdotto>{
	
	public List<FamiglieProdotto> getFamiglieByProdotto(int prodotto_id);
	public int deleteProdottoFamilies(int prodotto_id);
}
