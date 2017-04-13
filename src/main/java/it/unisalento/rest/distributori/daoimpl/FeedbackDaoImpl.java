/**
 * 
 */
package it.unisalento.rest.distributori.daoimpl;

import org.hibernate.Query;

import it.unisalento.rest.distributori.dao.FeedbackDao;
import it.unisalento.rest.distributori.domain.Feedback;

/**
 * @author aguinaldo
 *
 */
public class FeedbackDaoImpl extends BaseDaoImpl<Feedback> implements FeedbackDao {

	@Override
	public Long getNumMessaggiNonLetti() {
		Long numMessaggiNonLetti;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("select count(*) from Feedback as F where F.letto = 0");
			numMessaggiNonLetti = (Long) query.uniqueResult();
			tx.commit();
			return numMessaggiNonLetti;
		} finally{
			session.close();
		}

	}

}
