package com.example.madassignment.model;

public class Cart {
    private String Name, Price, quantity, Image;

    public Cart() {
    }

    public Cart(String name, String price, String quantity, String image) {
        Name = name;
        Price = price;
        this.quantity = quantity;
        Image = image;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
