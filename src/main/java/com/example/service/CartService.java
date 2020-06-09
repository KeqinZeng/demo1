package com.example.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;

    public String addBag(int userId, JSONArray bagItems){
        int cartId = cartMapper.searchCartId(userId).getId();
        for (int i = 0; i < bagItems.size(); i++){
           //int productId =Integer.parseInt(bagItems.get(i).get("productId"));
           //int productAmount = Integer.parseInt(bagItems.getJSONObject(i).get("productAmount"));
            JSONObject jsonObject = bagItems.getJSONObject(i);
            int productId = jsonObject.getInteger("productId");
            int productAmount = jsonObject.getInteger("productAmount");
            cartMapper.insertCart(cartId,productId,productAmount);
            }
        return "添加购物车成功";
    }
}
