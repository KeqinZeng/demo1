package com.example.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Cart;
import com.example.entity.CartItem;
import com.example.entity.Product;
import com.example.enums.UserEnums;
import com.example.exception.UserException;
import com.example.mapper.CartMapper;
import com.example.persistent.CartItemPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductService productService;

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

    public int searchUserId(int cartId){
        return cartMapper.searchUserId(cartId).getUserId();
    }


    public ArrayList<CartItem> showBag(int userId){
        ArrayList<CartItem> ItemsBack = new ArrayList<CartItem>();

        int cartId = cartMapper.searchCartId(userId).getId();
        //String bag = "";
        ArrayList<CartItemPO> items = cartMapper.searchCartItems(cartId);
        for (int i = 0; i < items.size(); i++){
            CartItem newItem =new CartItem();
            //int newId = items.get(i).getId();
            newItem.setId(items.get(i).getId());
            int newProductId = items.get(i).getId();
            Product newProduct = productService.getAProduct(newProductId);
            newItem.setProduct(newProduct);
            //int newProductAmount= items.get(i).getProductAmount();
            newItem.setProductAmount(items.get(i).getProductAmount());
            newItem.setCartId(cartId);
            ItemsBack.add(newItem);
            //bag += "Id = " +newId + " Product : " + newProduct +" ProductAmount = " + newProductAmount + "\n";
        }
        return ItemsBack;
    }


    public String cutBag(int cartItemId){
//        if(cartMapper.cutAItem(cartItemId) != 1){
//            throw new UserException(UserEnums.CART_WRONG);
//        }
        cartMapper.cutAItem(cartItemId);
        return "删除购物车内商品成功";
    }

    public void cutAItem(int cartItemId){
        cartMapper.cutAItem(cartItemId);
    }


    public String updateAmount(Map changeItem, int newProductAmount){
        //Object object = JSONObject.parse(changeItem); 
        //int cartItemId = Integer.parseInt(changeItem.get("cartItemId").toString());
        int cartItemId = Integer.parseInt(changeItem.get("id").toString());
        if (cartMapper.updateItemAmount(cartItemId, newProductAmount) != 1){
            throw new UserException(UserEnums.AMOUNTCHANGE_WRONG);
        }
        return "修改购物车内商品数量成功";
    }

    public String updateAmount2(CartItem changeItem){
        int cartItemId = changeItem.getId();
        int newProductAmount = changeItem.getProductAmount();
        //System.out.print(newProductAmount);
        if (cartMapper.updateItemAmount(cartItemId, newProductAmount) != 1){
            throw new UserException(UserEnums.AMOUNTCHANGE_WRONG);
        }
        return "修改购物车内商品数量成功";
    }

}
