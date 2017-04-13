/**
 * 
 */
package it.unisalento.rest.distributori.dao;

import it.unisalento.rest.distributori.domain.Feedback;

/**
 * @author aguinaldo
 *
 */
public interface FeedbackDao extends BaseDao<Feedback>{
	public Long getNumMessaggiNonLetti();

}
