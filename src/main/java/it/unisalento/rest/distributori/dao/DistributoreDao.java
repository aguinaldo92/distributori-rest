/**
 * 
 */
package it.unisalento.rest.distributori.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import it.unisalento.rest.distributori.domain.Distributore;

/**
 * @author aguinaldo
 * 
 */
public interface DistributoreDao extends BaseDao<Distributore> {
//	public ArrayList<DistributoreModel> getDistributoriVicini(BigDecimal lat, BigDecimal lon, Integer distanza);
	public ArrayList<Distributore> getDistributoriVicini(BigDecimal lat, BigDecimal lon, Integer distanza);
	public Distributore getBestDistributoreByPersona(Integer idPersona);
	
}