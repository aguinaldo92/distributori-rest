/**
 * 
 */
package it.unisalento.rest.distributori.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.rest.distributori.dao.FeedbackDao;
import it.unisalento.rest.distributori.domain.Feedback;

/**
 * @author aguinaldo
 *
 */
public class FeedbackDaoImpl extends BaseDaoImpl<Feedback> implements FeedbackDao {

	@Override
	public Long getNumMessaggiNonLetti() {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("select count(*) from Feedback as F where F.letto = 0");
			Long numMessaggiNonLetti = (Long) query.uniqueResult();
			tx.commit();
			return numMessaggiNonLetti;
		} finally{
			HibernateUtil.closeSession(session);
		}

	}

}
