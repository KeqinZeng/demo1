package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserInfo(int id);
    String getPwd(String name);
    int insertUser(String name, String pwd, String realName);
    int updatePwd(String name, String newPwd);
}
