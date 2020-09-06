package com.example.madassignment.model;

public class Cart {
    private String Product_ID,  Name, Price, quantity;

    public Cart() {
    }

    public Cart(String name, String price, String quantity) {
        Name = name;
        Price = price;
        this.quantity = quantity;
    }

    public String getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(String product_ID) {
        Product_ID = product_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
