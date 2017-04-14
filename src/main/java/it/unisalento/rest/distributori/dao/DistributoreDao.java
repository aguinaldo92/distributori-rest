/**
 * 
 */
package it.unisalento.rest.distributori.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.model.DistributoreModel;

/**
 * @author aguinaldo
 * 
 */
public interface DistributoreDao extends BaseDao<Distributore> {
//	public ArrayList<DistributoreModel> getDistributoriVicini(BigDecimal lat, BigDecimal lon, Integer distanza);
	public ArrayList<Distributore> getDistributoriVicini(BigDecimal lat, BigDecimal lon, Integer distanza);
	
}