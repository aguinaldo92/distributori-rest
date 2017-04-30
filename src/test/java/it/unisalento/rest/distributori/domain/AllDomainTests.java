package it.unisalento.rest.distributori.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AcquistaTest.class, CategoriaTest.class, CategorieForniteTest.class, DistributoreTest.class,
		FamigliaTest.class, FamiglieProdottoTest.class, FeedbackTest.class, PersonaTest.class,
		ProdottiErogatiTest.class, ProdottoTest.class, ProduttoreTest.class, StabilimentoTest.class })
public class AllDomainTests {

}
