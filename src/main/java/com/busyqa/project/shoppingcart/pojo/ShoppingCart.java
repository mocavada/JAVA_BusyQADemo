package com.busyqa.project.shoppingcart.pojo;

import java.util.ArrayList;

public class ShoppingCart {
    private Customer customer;
    private ArrayList<Product> products;

    public ShoppingCart(Customer customer, ArrayList<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public ShoppingCart() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
