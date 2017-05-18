/**
 * 
 */
package it.unisalento.rest.distributori.daoimpl;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.istack.internal.NotNull;

import it.unisalento.rest.distributori.dao.DistributoreDao;
import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.util.HibernateUtil;

/**
 * @author aguinaldo
 *
 */
public class DistributoreDaoImpl extends BaseDaoImpl<Distributore> implements DistributoreDao {

	@Override
	public ArrayList<Distributore> getDistributoriViciniOnline(@NotNull BigDecimal lat,@NotNull BigDecimal lon,@NotNull Integer distanza) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "SELECT D "+
						"FROM Distributore as D "+
						"WHERE GeoDistance(:myLat,:myLon,D.lat,D.lon)<:distanza AND (D.stato=1 OR D.stato=2)" ;
			
			Query query = session.createQuery(hql);
			query.setBigDecimal("myLat", lat);
			query.setBigDecimal("myLon", lon);
			query.setInteger("distanza", distanza);
			@SuppressWarnings("unchecked")
			ArrayList<Distributore> listDistributori = (ArrayList<Distributore>) query.list();
			tx.commit();
			return listDistributori;

		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}
