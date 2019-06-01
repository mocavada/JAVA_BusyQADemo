package com.busyqa.project.shoppingcart.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


public class Product {
    private long productID;
    private long modelID;
    private String name;

    public Product(long productID, long modelID, String name) {
        this.productID = productID;
        this.modelID = modelID;
        this.name = name;
    }


    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public long getModelID() {
        return modelID;
    }

    public void setModelID(long modelID) {
        this.modelID = modelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
