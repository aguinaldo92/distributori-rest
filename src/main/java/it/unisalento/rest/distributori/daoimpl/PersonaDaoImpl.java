/**
 * 
 */
package it.unisalento.rest.distributori.daoimpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.rest.distributori.dao.PersonaDao;
import it.unisalento.rest.distributori.domain.Distributore;
import it.unisalento.rest.distributori.domain.Persona;
import it.unisalento.rest.distributori.domain.SottoscrizioniDistributori;
import it.unisalento.rest.distributori.util.HibernateUtil;

/**
 * @author aguinaldo
 *
 */
public class PersonaDaoImpl extends BaseDaoImpl<Persona> implements PersonaDao {

	@Override
	public Persona getPersonaByCredentials(String email, String password) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Persona where email=:email and password=:password");
			query.setString("email", email); 
			query.setString("password", password);
			Persona persona = (Persona) query.uniqueResult();
			tx.commit();
			return persona;

		} finally{
			HibernateUtil.closeSession(session);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see it.unisalento.distributori.dao.PersonaDao#emailExists(java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean emailExists(String email, Integer my_ID) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			Query query;
			query = session.createQuery("from Persona where email=:email and id!=:id");
			query.setString("id", my_ID.toString());
			query.setString("email", email);
			Persona persona = (Persona) query.uniqueResult();
			tx.commit();
			if(persona != null){
				return true;
			} else {
				return false;
			}
		} finally{
			HibernateUtil.closeSession(session);
		}
	}

	@Override
	public boolean emailExists(String email) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			Query query;
			query = session.createQuery("from Persona where email=:email");
			query.setString("email", email);
			Persona persona = (Persona) query.uniqueResult();
			tx.commit();
			if(persona != null){
				return true;
			} else {
				return false;
			}
		} finally{
			HibernateUtil.closeSession(session);
		}
	}

	@Override
	public Integer setSottoscrizioneDistributore(SottoscrizioniDistributori sottoscrizione) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction(); //inizio transazione
			Integer id=(int)session.save(sottoscrizione);
			tx.commit(); //fine transazione
			//CHIUDERE LA SESSIONE
			return id;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally{
			session.close();
		}
	}

	@Override
	public ArrayList<Distributore> getSottoscrizioniByPersona(Integer idPersona) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "SELECT D "+
						"FROM SottoscrizioniDistributori as S inner join S.distributore as D "+
						"WHERE S.persona.id=:idPersona" ;
			
			Query query = session.createQuery(hql);
			query.setInteger("idPersona", idPersona);
			@SuppressWarnings("unchecked")
			ArrayList<Distributore> listDistributori = (ArrayList<Distributore>) query.list();
			tx.commit();
			return listDistributori;

		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	@Override
	public void deleteSottoscrizione(Integer idPersona, Integer idDistributore) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			String hql = "DELETE SottoscrizioniDistributori as S "
						+ "WHERE S.persona.id=:idPersona AND S.distributore.id=:idDistributore";
			Query query = session.createQuery(hql);
			query.setInteger("idPersona", idPersona);
			query.setInteger("idDistributore", idDistributore);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally{
			session.close();
		}
	}

}
