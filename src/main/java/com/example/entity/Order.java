package com.example.entity;

import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<OrderItem> orderItemList;
    private float totalOrderedPrice;
    private int orderNumber;
    private int userId;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public float getTotalOrderedPrice() {
        return totalOrderedPrice;
    }

    public void setTotalOrderedPrice(float totalOrderedPrice) {
        this.totalOrderedPrice = totalOrderedPrice;
    }
}
