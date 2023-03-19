package com.spring.expression.language.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("order")
public class Order {

    @Value("#{100 + 200}")
    private double amount;

    @Value("#{order.amount >= 1000 ? 10.0 : 0.0 }")
    private double discount;

    @Value("#{user.country == 'US' and user.timezone == 'Chicago' ? 3 : 7 }")
    private int daysToDeliver;

    @Value("#{user.country}")
    private String origin;

    @Value("#{T(java.text.NumberFormat).getCurrencyInstance(T(java.util.Locale).getDefault()).format(order.amount)}")
    private String formattedAmount;

    @Value("#{shipping.locationsByCountry[user.country]}")
    private List<City> shippingLocations;

    @Value("#{order.shippingLocations.?[isCapital != true]}")
    private List<City> nonCapitalShippingLocations;

    @Value("#{shipping.locationsByCountry.?[key == 'UK' or key == 'US']}")
    private Map<String, List<City>> westernShippingLocations;

    @Value("#{order.shippingLocations.?[shipping <= 10].size()}")
    private Integer affordableShippingLocations;

    @Value("#{user.name} your order total is #{order.formattedAmount} and the payable amount with 10% discount is #{order.amount}")
    private String orderSummary;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getDaysToDeliver() {
        return daysToDeliver;
    }

    public void setDaysToDeliver(int daysToDeliver) {
        this.daysToDeliver = daysToDeliver;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFormattedAmount() {
        return formattedAmount;
    }

    public void setFormattedAmount(String formattedAmount) {
        this.formattedAmount = formattedAmount;
    }

    public List<City> getShippingLocations() {
        return shippingLocations;
    }

    public void setShippingLocations(List<City> shippingLocations) {
        this.shippingLocations = shippingLocations;
    }

    public List<City> getNonCapitalShippingLocations() {
        return nonCapitalShippingLocations;
    }

    public void setNonCapitalShippingLocations(List<City> nonCapitalShippingLocations) {
        this.nonCapitalShippingLocations = nonCapitalShippingLocations;
    }

    public Map<String, List<City>> getWesternShippingLocations() {
        return westernShippingLocations;
    }

    public Integer getAffordableShippingLocations() {
        return affordableShippingLocations;
    }

    public void setWesternShippingLocations(Map<String, List<City>> westernShippingLocations) {
        this.westernShippingLocations = westernShippingLocations;
    }

    public void setAffordableShippingLocations(Integer affordableShippingLocations) {
        this.affordableShippingLocations = affordableShippingLocations;
    }

    public String getOrderSummary() {
        return orderSummary;
    }

    public void setOrderSummary(String orderSummary) {
        this.orderSummary = orderSummary;
    }
}
