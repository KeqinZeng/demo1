package com.example.mapper;


import com.example.persistent.OrderItemPO;
import com.example.persistent.OrderPO;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderMapper {
    void createOrder(OrderPO newOrder);
    void updateTotalPrice(int orderId, float totalPrice);
    void createOrderItem(OrderItemPO newOrderItem);
    OrderPO searchOrder(int orderNumber);
}
