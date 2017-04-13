/**
 * 
 */
package it.unisalento.rest.distributori.daoimpl;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.hibernate.Query;

import it.unisalento.rest.distributori.dao.DistributoreDao;
import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.model.DistributoreModel;

/**
 * @author aguinaldo
 *
 */
public class DistributoreDaoImpl extends BaseDaoImpl<Distributore> implements DistributoreDao {

	@Override
	public ArrayList<DistributoreModel> getDistributoriVicini(BigDecimal lat, BigDecimal lon, Integer distanza) {
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			String hql = "select id,lat,lon,indirizzo,posizioneEdificio from Distributore d where ( d.lat - :lat < :distanza ) and  ( d.lon - :lon < :distanza ) " ;
			Query query = session.createQuery(hql);
			query.setBigDecimal("lat", lat);
			query.setBigDecimal("lon", lon);
			query.setInteger("distanza", distanza);
			ArrayList<DistributoreModel> listDistributoreModel = (ArrayList<DistributoreModel>) query.list();
			tx.commit();
			return listDistributoreModel;

		} finally {
			session.close();
		}
	}

	/*
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Distributore> getDistributoriByIdDipendenteSortedByStato(Integer idDipendente) {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
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
			tx = session.beginTransaction();
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
