package com.busyqa.project.shoppingcart.service;

import com.busyqa.project.shoppingcart.pojo.Customer;
import com.busyqa.project.shoppingcart.pojo.Product;
import com.busyqa.project.shoppingcart.pojo.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShoppingService {

    @Autowired
    private ApplicationContext context;

    public ShoppingCart getMyShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(new Customer(1, "James"));


        //======== (1) normal way
        Product p1 = new Product(0, 0, "CellPhone");
        Product p2 = new Product(1, 1, "Computer");
        ArrayList<Product> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        shoppingCart.setProducts(pList);

        //======== (2) anonymous way
//        shoppingCart.setProducts(new ArrayList<Product>() {{
//            add(new Product(0,0, "CellPhone"));
//            add(new Product(1,1, "Computer"));
//        }});

        return shoppingCart;
    }

    public ShoppingCart getMyShoppingCartFromBean() {
        ShoppingCart shoppingCartFromBean = context.getBean(ShoppingCart.class);
        return shoppingCartFromBean;

    }
}
