package com.hieunv.entity;

import java.io.Serializable;

public class student implements Serializable {
    private String name;
    private String address;
    private String phone;
    private String className;

    public student() {
    }
    public student(String name, String address, String phone, String className) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String toCookieValue() {
        return name + "=" + address + "=" + phone + "=" + className;
    }

    public student fromCookieValue(String value) {
        String[] arr = value.split("=");
        return new student(arr[0], arr[1], arr[2], arr[3]);
    }
}
