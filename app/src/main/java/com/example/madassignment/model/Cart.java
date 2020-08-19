package com.example.madassignment.model;

public class Cart {
    private String pname, pprice, quantity, pimage;

    public Cart() {
    }

    public Cart(String pname, String pprice, String quantity, String pimage) {
        this.pname = pname;
        this.pprice = pprice;
        this.quantity = quantity;
        this.pimage = pimage;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }
}
