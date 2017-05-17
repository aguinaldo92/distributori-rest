package it.unisalento.rest.distributori.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PasswordUtilsTest.class,ResultDispatcherTest.class, HibernateUtilTest.class, TokenUtilsTest.class })
public class AllUtilTests {

}
