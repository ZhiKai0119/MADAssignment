package com.example.madassignment;

public class User {
    private String Delivery;
    private String Name;
    private String Address;
    private Integer PhoneNo;
    private String Email;
    private String City;
    private String State;
    private Integer Postcode;

    public User(){

    }

    public String getDelivery() {
        return Delivery;
    }

    public void setDelivery(String delivery) {
        Delivery = delivery;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Integer getPostcode() {
        return Postcode;
    }

    public void setPostcode(Integer postcode) {
        Postcode = postcode;
    }
}
