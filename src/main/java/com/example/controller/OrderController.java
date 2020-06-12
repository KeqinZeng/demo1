package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Cart;
import com.example.entity.CartItem;
import com.example.service.CartService;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value="newOrder", method = RequestMethod.POST)
    public String newOrder(HttpServletRequest request){
        //request.getParameter("cartItems")
        JSONArray cartItems= JSONObject.parseArray(request.getParameter("cartItems"));
        return orderService.newOrder(cartItems);

    }

}
