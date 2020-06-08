package com.example.mapper;

import com.example.entity.Cart;
import com.example.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserInfo(int id);
    String getPwd(String name);
    int insertUser(User newUser);
    int updatePwd(String name, String newPwd);
    int newACart(Cart newCart);
}
