package com.example.madassignment;

import java.util.Date;

public class Member1 {
    private String Name;
    private String BankName;
    private Integer Number;
    private Integer Date;
    private Integer cvvNum;

    public Member1(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Integer getCvvNum() {
        return cvvNum;
    }

    public void setCvvNum(Integer cvvNum) {
        this.cvvNum = cvvNum;
    }
}
