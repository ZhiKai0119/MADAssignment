package com.example.madassignment.model;

public class WishList {
    private String product_id, product_Name, product_Price;

    public WishList() {
    }

    public WishList(String product_Name, String product_Price) {
        this.product_Name = product_Name;
        this.product_Price = product_Price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(String product_Price) {
        this.product_Price = product_Price;
    }
}
