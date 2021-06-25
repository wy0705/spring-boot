package com.example.demo.using.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int uid;
    private String name;
    private String phone;
    private String password;
    private String address;
    private int grade;
    private int admin_college;

    public int getAdmin_college() {
        return admin_college;
    }

    public void setAdmin_college(int admin_college) {
        this.admin_college = admin_college;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User(String name, String phone, String password, String address, int grade) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.grade = grade;
    }

    public User(int uid, String name, String phone, String password, String address, int grade, int admin_college) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.grade = grade;
        this.admin_college = admin_college;
    }
}
