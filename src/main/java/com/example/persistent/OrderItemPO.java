package com.example.persistent;

public class OrderItemPO {
    private int id;
    private int orderId;
    private int productId;
    private int productAmount;

    public OrderItemPO(int orderId, int productId, int productAmount) {
        this.orderId = orderId;
        this.productId = productId;
        this.productAmount = productAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }
}
