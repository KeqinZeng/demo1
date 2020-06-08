package com.example.entity;

import java.util.ArrayList;

public class User {
    private int id;
    private String userName;
    private String passWord;
    private String realName;
    private Cart cart;
    private ArrayList<Order> OrderList;

    public User(String userName, String passWord, String realName) {
        this.userName = userName;
        this.passWord = passWord;
        this.realName = realName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ArrayList<Order> getOrderList() {
        return OrderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        OrderList = orderList;
    }

    @Override
    public String toString(){
        return "ID =" + this.id + " UserName = " + this.userName + " PWD =" + this.passWord + " RealName = " + this.realName ;
    }


}
