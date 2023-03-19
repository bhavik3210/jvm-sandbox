package com.spring.expression.language.controller;

import com.spring.expression.language.data.City;
import com.spring.expression.language.data.Order;
import com.spring.expression.language.data.Shipping;
import com.spring.expression.language.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    Order order;

    @Autowired
    User user;

    @Autowired
    Shipping shipping;

    @Autowired
    City city;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String getCustomer() {
        return user.getName();
    }

    @RequestMapping(value = "/amount", method = RequestMethod.GET)
    public double getOrderAmount() {
        return order.getAmount();
    }

    @RequestMapping(value = "/discount", method = RequestMethod.GET)
    public double getDiscount() {
        return order.getDiscount();
    }

    @RequestMapping(value = "/origin", method = RequestMethod.GET)
    public String getOrigin() {
        return order.getOrigin();
    }


    @RequestMapping(value = "/deliver", method = RequestMethod.GET)
    public int getDeliver() {
        return order.getDaysToDeliver();
    }

    @RequestMapping(value = "/amount/formatted", method = RequestMethod.GET)
    public String getFormattedOrderAmount() {
        return order.getFormattedAmount();
    }

    @RequestMapping(value = "/shipping/locations", method = RequestMethod.GET)
    public List<City> getShippingLocations() {
        return order.getShippingLocations();
    }

    @RequestMapping(value = "/shipping/locations/noncapital")
    public List<City> getNonCapitalShippingLocations() {
        return order.getNonCapitalShippingLocations();
    }

    @RequestMapping(value = "/shipping/locations/western")
    public Map<String, List<City>> getWesternShippingLocations() {
        return order.getWesternShippingLocations();
    }

    @RequestMapping(value = "/shipping/locations/affordable")
    public Integer getNumberOfAffordableShippingLocations() {
        return order.getAffordableShippingLocations();
    }

    @RequestMapping(value = "/summary")
    public String getOrderSummary() {
        return order.getOrderSummary();
    }

}
