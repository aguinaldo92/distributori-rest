package it.unisalento.rest.distributori.daoimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Logger logger;

	/*
	 * per inizializzare le variabili statiche si utilizza il blocco static che viene
	 * eseguito prima del costruttore. In questa maniera siamo sicuri che sessionFactory
	 * anzich� essere ricreato a ogni connessione al DB , sar� unico in tutta l'app
	 */

	static {
		logger = LogManager.getLogger(HibernateUtil.class.getName());
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		serviceRegistry = serviceRegistryBuilder.build();
		try{
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable e){
			logger.error("il DB non � raggiungibile, non � possibile generare la sessionFactory", e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public HibernateUtil() {

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static ServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}

	//per ottenere direttamente la session all'interno della classe DAO
	public static Session getSession() {
		try {
			return sessionFactory.openSession();
		}catch (Exception e){
			logger.error("Impossibile connettersi al DB",e);
			throw e;
		}
	}

	public static void closeSession(Session session){
		session.close();
	}

}
