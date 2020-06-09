package com.example.entity;

import java.util.ArrayList;

public class Cart {
    private int id;
    private ArrayList<CartItem> cartItemList;
    private int userId;
    private Float totalPrice;


    public Cart(int userId) {
        this.userId = userId;
    }

    public Cart(int id, int userId, Float totalPrice) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(ArrayList<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}

