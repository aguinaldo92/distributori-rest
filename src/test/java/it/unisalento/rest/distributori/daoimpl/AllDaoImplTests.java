package it.unisalento.rest.distributori.daoimpl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AcquistaDaoImplTest.class, CategoriaDaoImplTest.class, CategorieForniteDaoImplTest.class,
		DistributoreDaoImplTest.class, FeedbackDaoImplTest.class, PersonaDaoImplTest.class,
		ProdottiErogatiDaoImplTest.class, ProdottoDaoImplTest.class })
public class AllDaoImplTests {

}
