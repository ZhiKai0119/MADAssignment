package com.example.madassignment.model;

import java.io.Serializable;

public class ProductModel implements Serializable {

    private String productName;

    public ProductModel(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
