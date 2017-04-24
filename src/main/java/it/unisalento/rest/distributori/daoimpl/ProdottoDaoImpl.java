/**
 * 
 */
package it.unisalento.rest.distributori.daoimpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.rest.distributori.dao.ProdottoDao;
import it.unisalento.rest.distributori.domain.Prodotto;

/**
 * @author aguinaldo
 *
 */
public class ProdottoDaoImpl extends BaseDaoImpl<Prodotto> implements ProdottoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> getAllProdotti() {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Prodotto as P where P.nome!=:vuoto order by P.nome");
			query.setString("vuoto", "Vuoto");
			List<Prodotto> list_prodotti = new ArrayList<Prodotto>();
			list_prodotti=query.list();
			tx.commit();
			return list_prodotti;
		} finally{
			HibernateUtil.closeSession(session);
		}
	}

	//TODO: migliorare cmposizione query.
	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> getAllProdottiFiltrati(List<String> list_fam_IDs, List<String> list_categ_IDs) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			String querystring="select distinct P from Prodotto as P inner join P.categoria as C inner join C.prodottos as P inner join P.famiglieProdottos as F where P.nome != :vuoto and ";

			//aggiunta delle condizioni di filtraggio alla query
			String chiusura_cond_categ="";
			if(list_categ_IDs.size()>0 && list_fam_IDs.size()>0)
				chiusura_cond_categ=") and ";
			for(int i=0; i<list_categ_IDs.size(); i++){
				if (i==0){
					querystring=querystring.concat("( C.id="+list_categ_IDs.get(i)+" ");
				}else
					querystring=querystring.concat("or C.id="+list_categ_IDs.get(i)+" ");
			}
			querystring=querystring.concat(chiusura_cond_categ);
			for(int i=0; i<list_fam_IDs.size(); i++){
				if (i==0)
					querystring=querystring.concat("( F.famiglia.id="+list_fam_IDs.get(i)+" ");
				else
					querystring=querystring.concat("or F.famiglia.id="+list_fam_IDs.get(i)+" ");
			}
			querystring=querystring.concat(") order by P.nome");

			Query query = session.createQuery(querystring);
			query.setString("vuoto", "Vuoto");

			List<Prodotto> list_prodotti = new ArrayList<Prodotto>();
			list_prodotti=query.list();

			tx.commit();
			return list_prodotti;
		} finally{
			HibernateUtil.closeSession(session);
		}
	}
	@Override
	public ArrayList<Prodotto> getProdottiCompatibiliByDistributore(Integer idDistributore) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			String hql = "select P from Distributore as D inner join D.categorieFornites as CF inner join CF.categoria as C1 inner join C1.prodottos as P inner join P.categoria as C2 where D.id = :idDistributore and C1.id = C2.id  order by C1.nome, P.nome" ;
			Query query = session.createQuery(hql);
			query.setInteger("idDistributore", idDistributore);
			@SuppressWarnings("unchecked")
			ArrayList<Prodotto> listProdottiCompatibili = (ArrayList<Prodotto>) query.list();
			tx.commit();
			return listProdottiCompatibili;

		} finally{
			HibernateUtil.closeSession(session);
		}
	}

	@Override
	public Prodotto getProdottoVuoto(){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Prodotto as P where P.nome = :vuoto");
			// hibernate non � case sensitive nelle clausole where 
			query.setString("vuoto", "Vuoto");
			Prodotto prodottoVuoto = new Prodotto();
			prodottoVuoto = (Prodotto) query.uniqueResult();

			tx.commit();
			return prodottoVuoto;

		} finally{
			HibernateUtil.closeSession(session);
		}

	}

}
