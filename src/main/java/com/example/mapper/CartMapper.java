package com.example.mapper;


import com.example.entity.Cart;
import com.example.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper {
    int insertCart(int cartId, int productId, int productAmount);
    Cart searchCartId(int userId);
}
