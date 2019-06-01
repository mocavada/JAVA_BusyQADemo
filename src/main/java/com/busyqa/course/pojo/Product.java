package com.busyqa.course.pojo;

import java.util.Date;

public class Product {

    private String description;
    private Integer price;
    private Date availableFrom;
    private boolean onStock;
    private ProductType productType;

    public Product(final String description, final Integer price, final Date availableFrom, final ProductType productType) {
        this.description = description;
        this.price = price;
        this.availableFrom = availableFrom;
        this.productType = productType;
    }

    public Date getAvailableFrom() {
        return this.availableFrom;
    }

    public void setAvailableFrom(final Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public boolean isOnStock() {
        return onStock;
    }

    public void setOnStock(boolean onStock) {
        this.onStock = onStock;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
