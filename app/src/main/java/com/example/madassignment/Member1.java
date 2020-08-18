package com.example.madassignment;

public class Member1 {
    private String Name;
    private String BankName;
    private Integer Number;
    private String Date;
    private Integer ccvNum;

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

    public String getDate() {
        return String.valueOf(Date);
    }

    public void setDate(String date) {
        Date = date;
    }

    public Integer getCcvNum() {
        return ccvNum;
    }

    public void setCcvNum(Integer ccvNum) {
        this.ccvNum = ccvNum;
    }
}
