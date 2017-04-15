/**
 * 
 */
package it.unisalento.rest.distributori.factory;

import it.unisalento.rest.distributori.dao.CategoriaDao;
import it.unisalento.rest.distributori.dao.CategorieForniteDao;
import it.unisalento.rest.distributori.dao.DistributoreDao;
import it.unisalento.rest.distributori.dao.FeedbackDao;
import it.unisalento.rest.distributori.dao.PersonaDao;
import it.unisalento.rest.distributori.dao.ProdottiErogatiDao;
import it.unisalento.rest.distributori.dao.ProdottoDao;
import it.unisalento.rest.distributori.dao.ProduttoreDao;
import it.unisalento.rest.distributori.daoimpl.CategoriaDaoImpl;
import it.unisalento.rest.distributori.daoimpl.CategorieForniteDaoImpl;
import it.unisalento.rest.distributori.daoimpl.DistributoreDaoImpl;
import it.unisalento.rest.distributori.daoimpl.FeedbackDaoImpl;
import it.unisalento.rest.distributori.daoimpl.PersonaDaoImpl;
import it.unisalento.rest.distributori.daoimpl.ProdottiErogatiDaoImpl;
import it.unisalento.rest.distributori.daoimpl.ProdottoDaoImpl;
import it.unisalento.rest.distributori.daoimpl.ProduttoreDaoImpl;

/**
 * @author aguinaldo
 *
 */
public class FactoryDao {

	static private class Holder{
		static final private FactoryDao ISTANCE=new FactoryDao();
	}

	public static FactoryDao getIstance(){
		//System.out.println("FactoryDao: getIstance()");
		return Holder.ISTANCE;
	}

	public PersonaDao getPersonaDao(){
		//System.out.println("FactoryDao: getPersonaDao");
		return new PersonaDaoImpl();
	}

	public ProdottoDao getProdottoDao(){
		//System.out.println("FactoryDao: getProdottoDao");
		return new ProdottoDaoImpl();
	}

	public CategoriaDao getCategoriaDao(){
		//System.out.println("FactoryDao: getCategoriaDao");
		return new CategoriaDaoImpl();
	}

//	public FamigliaDao getFamigliaDao(){
//		//System.out.println("FactoryDao: getFamigliaDao");
//		return new FamigliaDaoImpl();
//	}

	public ProduttoreDao getProduttoreDao(){
		//System.out.println("FactoryDao: getProduttoreDao");
		return new ProduttoreDaoImpl();
	}
//	
//	public StabilimentoDao getStabilimentoDao(){
//		//System.out.println("FactoryDao: getStabilimentoDao");
//		return new StabilimentoDaoImpl();
//	}

	public DistributoreDao getDistributoreDao(){
		//System.out.println("FactoryDao: getDistributoreDao");
		return new DistributoreDaoImpl();
	}

	public CategorieForniteDao getCategorieForniteDao(){
		//System.out.println("FactoryDao: getCategorieForniteDao");
		return new CategorieForniteDaoImpl();
	}

	public ProdottiErogatiDao getProdottiErogatiDao(){
		//System.out.println("FactoryDao: getProdottiErogatiDao");
		return new ProdottiErogatiDaoImpl();
	}
//	
//	public FamiglieProdottoDao getFamiglieProdottoDao(){
//		//System.out.println("FactoryDao: getFamiglieProdottoDao");
//		return new FamiglieProdottoDaoImpl();
//	}
	public FeedbackDao getFeedbackDao(){
		//System.out.println("FactoryDao: getFeedbackDao");
		return new FeedbackDaoImpl();
	}
}
