package com.spring.aop.dao;

import com.spring.aop.exceptions.CountryDoesNotExistException;
import com.spring.aop.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer, Passenger> passengerMap = new HashMap<>();

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private RowMapper<Passenger> rowMapper = (resultSet, rowNum) -> {
        Passenger passenger = new Passenger();
        passenger.setName(resultSet.getString("name"));
        passenger.setCountry("country");
        return passenger;
    };

    public static Map<Integer, Passenger> getPassengerMap() {
        return passengerMap;
    }

    private Passenger getById(int id) {
        String sql = "SELECT * FROM PASSENGERS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void insert(Passenger passenger) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(passenger.getCountry())) {
            throw new CountryDoesNotExistException(passenger.getCountry());
        }
        String sql = "INSERT INTO PASSENGER (NAME, COUNTRY) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{passenger.getName(), passenger.getCountry()});
    }

    @Override
    public Passenger getPassenger(int id) {
        if (passengerMap.get(id) != null) {
            return passengerMap.get(id);
        }

        Passenger passenger = getById(id);
        return passenger;
    }
}
