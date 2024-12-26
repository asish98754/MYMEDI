package com.example.mymedi;

public class UserHelperClassPharmacy {

    String name,username,regNo,address,phoneNo,password;

    public UserHelperClassPharmacy() {
    }

    public UserHelperClassPharmacy(String name, String username, String regNo, String address, String phoneNo, String password) {
        this.name = name;
        this.username = username;
        this.regNo = regNo;
        this.address = address;
        this.phoneNo = phoneNo;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
