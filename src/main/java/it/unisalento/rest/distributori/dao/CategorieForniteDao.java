/**
 * 
 */
package it.unisalento.rest.distributori.dao;

import java.util.List;
import it.unisalento.rest.distributori.domain.CategorieFornite;

/**
 * @author aguinaldo
 *
 */
public interface CategorieForniteDao extends BaseDao<CategorieFornite>{
	
	public List<CategorieFornite> getCategorieForniteByIdDistributore(Integer idDistributore);
	public List<CategorieFornite> getCategorieForniteByIdDistributoreListCategorieScelte(Integer idDistributore, List<String> listCategorieScelte);


}
