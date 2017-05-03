package it.unisalento.rest.distributori.customdialect;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.FloatType;
import org.hibernate.type.StringType;

public class CustomMySQLDialect extends MySQL5InnoDBDialect {
	 public CustomMySQLDialect()
     {
            super();
            /* GeoDistance(myLat, myLon, lat, lon) = Kilometers */
            registerFunction("GeoDistance", new SQLFunctionTemplate(FloatType.INSTANCE, "GeoDistance(?1, ?2, ?3, ?4)"));
     }
}
