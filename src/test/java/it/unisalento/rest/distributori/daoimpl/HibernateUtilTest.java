package it.unisalento.rest.distributori.daoimpl;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void testHibernateUtil() throws Exception {
		HibernateUtil util = new HibernateUtil();
		assertNotNull(util);
	}

	@Test
	public void testGetSessionFactory() throws Exception {
		SessionFactory fact = HibernateUtil.getSessionFactory();
		
		assertNotNull(fact);
	}

	@Test
	public void testGetServiceRegistry() throws Exception {
		ServiceRegistry reg = HibernateUtil.getServiceRegistry();
		
		assertNotNull(reg);
	}

	@Test
	public void testGetSession() throws Exception {
		Session session = it.unisalento.rest.distributori.daoimpl.HibernateUtil.getSession();
		
		assertNotNull(session);
		
		it.unisalento.rest.distributori.daoimpl.HibernateUtil.closeSession(session);
		
		assertFalse(session.isOpen());
	}

}
