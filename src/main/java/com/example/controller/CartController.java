package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Cart;
import com.example.entity.CartItem;
import com.example.service.CartService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "*")
    @RequestMapping(value="showBag", method = RequestMethod.POST)
    public ArrayList<CartItem> showBag(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        return cartService.showBag(userId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="cutBag", method = RequestMethod.POST)
    public String cutBag(HttpServletRequest request){
        int cartItemId = Integer.parseInt(request.getParameter("id"));
        return cartService.cutBag(cartItemId);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="updateAmount", method = RequestMethod.POST)
    public String updateAmount(HttpServletRequest request){
        //Object changeItem = JSONObject.parse(request.getParameter("changeItems"));
        //Map<String, Object> changeItem=(Map<String, Object>)JSONObject.parse(request.getParameter("changeItem"));
        Map changeItem = JSON.parseObject(request.getParameter("changeItem"),Map.class);
        //Map<String, Object> changeItem = (Map<String, Object>)JSONObject.parse(request.getParameter("changeItem"));
        int newProductAmount = Integer.parseInt(request.getParameter("newAmount"));
        return cartService.updateAmount(changeItem, newProductAmount);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="updateAmount2", method = RequestMethod.POST)
    public String updateAmount2(HttpServletRequest request){
        System.out.println(request.getParameter("cartItem"));
        CartItem cartItem =JSONObject.parseObject(request.getParameter("cartItem"),CartItem.class);
        System.out.println(cartItem.toString());
        System.out.println(cartItem.getProduct().toString());
        return cartService.updateAmount2(cartItem);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="updateAmount3",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String updateAmount3(CartItem cartItem){
        System.out.println(cartItem);
        return cartService.updateAmount2(cartItem);
    }






}
