package com.spring.aop;

import com.spring.aop.aspects.CachingAspect;
import com.spring.aop.aspects.CountryDoesNotExistAspect;
import com.spring.aop.aspects.LoggingAspect1;
import com.spring.aop.aspects.LoggingAspect2;
import com.spring.aop.dao.PassengerDaoImpl;
import com.spring.aop.model.Flight;
import com.spring.aop.model.Passenger;
import com.spring.aop.model.Ticket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public DataSource getDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).addScript("classpath:db-schema.sql").build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean(name = "passengerDao")
    public PassengerDaoImpl getPassengerDao() {
        return new PassengerDaoImpl();
    }

    @Bean(name = "flight")
    public Flight getFlight() {
        return new Flight(
                "AA1234",
                "ABC Flights",
                List.of(new Passenger("Jim", "US"), new Passenger("Jack", "UK"), new Passenger("Jill", "AU"))
        );
    }

    @Bean(name = "ticket")
    public Ticket getTicket() {
        return new Ticket("1234567890", new Passenger("Jim", "US"));
    }

    @Bean(name = "loggingAspect1")
    public LoggingAspect1 getLoggingAspect1() {
        return new LoggingAspect1();
    }

    @Bean(name = "loggingAspect2")
    public LoggingAspect2 getLoggingAspect2() {
        return new LoggingAspect2();
    }

    @Bean(name = "cachingAspect")
    public CachingAspect getCachingAspect() {
        return new CachingAspect();
    }

    @Bean(name = "countryDoesNotExistAspect")
    public CountryDoesNotExistAspect getCountryDoesnotExistAspect() {
        return new CountryDoesNotExistAspect();
    }
}
