package com.example.mapper;


import com.example.entity.Cart;
import com.example.entity.CartItem;
import com.example.entity.Product;
import com.example.persistent.CartItemPO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CartMapper {
    int insertCart(int cartId, int productId, int productAmount);
    Cart searchCartId(int userId);
    Cart searchUserId(int cartId);
    //ArrayList<ArrayList<Integer>> searchCartItems(int cartId);
    ArrayList<CartItemPO> searchCartItems(int cartId);
    void cutAItem(int cartItemId);
    int updateItemAmount(int cartItemId, int newProductAmount);



}
