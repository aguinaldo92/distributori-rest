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

/**
 * @author aguinaldo
 *
 */
public class DistributoreDaoImpl extends BaseDaoImpl<Distributore> implements DistributoreDao {

	@Override
	public ArrayList<Distributore> getDistributoriVicini(@NotNull BigDecimal lat,@NotNull BigDecimal lon,@NotNull Integer distanza) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			String hql = "select  D "+
					"from Distributore as D join D.categorieFornites as CF join CF.categoria as C "+
					"where ( D.lat - :lat < :distanza ) and  ( D.lon - :lon < :distanza ) "+
					"group by D.id" ;
			Query query = session.createQuery(hql);
			query.setBigDecimal("lat", lat);
			query.setBigDecimal("lon", lon);
			query.setInteger("distanza", distanza);
			@SuppressWarnings("unchecked")
			ArrayList<Distributore> listDistributori = (ArrayList<Distributore>) query.list();
			tx.commit();
			return listDistributori;

		} finally {
			HibernateUtil.closeSession(session);
		}
	}

//	@Override
//	public ArrayList<DistributoreModel> getDistributoriVicini(BigDecimal lat, BigDecimal lon, Integer distanza) {
//		try{
//			session = HibernateUtil.getSession();
//			Transaction tx = session.beginTransaction();
//			String hql = "select  d.id,d.lat,d.lon,d.indirizzo,d.posizioneEdificio, group_concat(C.nome) "+
//					"from Distributore as d join d.categorieFornites as CF join CF.categoria as C "+
//					"where ( d.lat - :lat < :distanza ) and  ( d.lon - :lon < :distanza ) and C.nome != 'Generica' "+
//					"group by d.id" ;
//			Query query = session.createQuery(hql);
//			query.setBigDecimal("lat", lat);
//			query.setBigDecimal("lon", lon);
//			query.setInteger("distanza", distanza);
//			ArrayList<DistributoreModel> listDistributori = (ArrayList<DistributoreModel>) query.list();
//			tx.commit();
//			return listDistributori;
//
//		} finally {
//			session.close();
//		}
//	}

	/*
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Distributore> getDistributoriByIdDipendenteSortedByStato(Integer idDipendente) {
		try {
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Distributore d where d.dipendente.id = :idDipendente";
			Query query = session.createQuery(hql);
			query.setInteger("idDipendente", idDipendente);
			ArrayList<Distributore> listDistributore = (ArrayList<Distributore>) query.list();
			tx.commit();
			return listDistributore;

		} finally {
			session.close();
		}

	}

	@Override
	public Long getNumDistributoriNonOk() {
		Long numDistributoriNonOk;
		try {
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("select count(*) as num from Distributore as D where D.stato = 0 or D.stato = 1 or D.stato = 3");
			numDistributoriNonOk = (Long) query.uniqueResult();
			tx.commit();
			return numDistributoriNonOk;

		} finally {
			session.close();
		}
	}
	 */
}
