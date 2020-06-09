package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.service.CartService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/mycart")
public class CartController {

    @Autowired
    private CartService cartService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value="addBag", method = RequestMethod.POST)
    public String addBag(HttpServletRequest request){
        //String bagItems = request.getParameter("bagItems");
        int userId=Integer.parseInt(request.getParameter("userId"));
        JSONArray bagItemsArray= JSONObject.parseArray(request.getParameter("bagItems"));
        return cartService.addBag(userId, bagItemsArray);
    }
}
