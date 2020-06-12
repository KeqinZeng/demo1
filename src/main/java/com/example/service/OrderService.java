package com.example.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.CartItem;
import com.example.entity.Product;
import com.example.mapper.OrderMapper;
import com.example.persistent.OrderItemPO;
import com.example.persistent.OrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CartService cartService;

    public String newOrder(JSONArray cartItems) {

        JSONObject jsonFirstObject = cartItems.getJSONObject(0);
        int cartId = jsonFirstObject.getInteger("cartId");
        int userId = cartService.searchUserId(cartId);
        float totalPrice = 0;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd"); //精确到日
        String suffix = fmt.format(new Date());
        int orderNumber = Integer.parseInt(suffix + userId);

        OrderPO newOrder = new OrderPO(orderNumber, userId, totalPrice);
        orderMapper.createOrder(newOrder);

        int orderId = orderMapper.searchOrder(orderNumber).getId();

        for (int i = 0; i < cartItems.size(); i++) {
            JSONObject jsonObject = cartItems.getJSONObject(i);

            Product product = jsonObject.getObject("product", Product.class);
            float perPrice = product.getProductPrice();
            int productId = product.getId();
            int productAmount = jsonObject.getInteger("productAmount");
            totalPrice += perPrice * productAmount;

            OrderItemPO newOrderItem = new OrderItemPO(orderId, productId, productAmount);
            orderMapper.createOrderItem(newOrderItem);

            int cartItemId = jsonObject.getInteger("id");
            cartService.cutAItem(cartItemId);
        }
        orderMapper.updateTotalPrice(orderId, totalPrice);

        return "下单成功";
    }
}

