package com.busyqa.project.shoppingcart.service;

import com.busyqa.project.shoppingcart.pojo.Customer;
import com.busyqa.project.shoppingcart.pojo.Product;
import com.busyqa.project.shoppingcart.pojo.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;

@Configuration
public class ConfigShoppingCart {
    @Bean
    public ShoppingCart shoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(new Customer(1, "James"));


        //======== (1) normal way
        Product p1 = new Product(0, 0, "CellPhone");
        Product p2 = new Product(1, 1, "Computer");
        ArrayList<Product> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        shoppingCart.setProducts(pList);

        //======== (2) anonymous  way
//        shoppingCart.setProducts(new ArrayList<Product>() {{
//            add(new Product(0,0, "CellPhone"));
//            add(new Product(1,1, "Computer"));
//        }});

        return shoppingCart;
    }


}