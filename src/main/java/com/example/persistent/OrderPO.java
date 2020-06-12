package com.example.persistent;

public class OrderPO {
    private int id;
    private int orderNumber;
    private int userId;
    private float totalPrice;

    public OrderPO(int id, int orderNumber, int userId, float totalPrice) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public OrderPO(int orderNumber, int userId, float totalPrice) {
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
