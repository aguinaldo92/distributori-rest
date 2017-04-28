/**
 * 
 */
package it.unisalento.rest.distributori.dao;

import java.util.ArrayList;
import it.unisalento.rest.distributori.domain.ProdottiErogati;

/**
 * @author aguinaldo
 *
 */
public interface ProdottiErogatiDao extends BaseDao<ProdottiErogati>{
	
	public ArrayList<ProdottiErogati> getProdottiErogatiByDistributoreSortedByScaffalePosto(Integer idDistributore);
//	public ArrayList<ProdottiErogati> getProdottiScarseggiantiByDistributore(Integer idDistributore);

}
