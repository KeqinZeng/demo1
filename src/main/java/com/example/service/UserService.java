package com.example.service;

import com.example.enums.UserEnums;
import com.example.exception.UserException;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    public String userLogin(String name, String pwd){
        String gainPwd = userMapper.getPwd(name);
        if (gainPwd == null){
            logger.info("无[{}]用户", name);
            //return "无用户";
            return UserEnums.NO_NAME.getMessage();
        }else if (gainPwd.equals(pwd)){
            logger.info("[{}]用户登录成功", name);
            return "Success!";
        }else{
            logger.info("[{}]用户登录失败", name);
            //return "Wrong!";
            return UserEnums.PWD_ERROR.getMessage();
        }
    }

    public String userReg(String name, String pwd, String realName){
//        if (name == null){
//            return UserEnums.EMPTY_NAME.getMessage();
//        }
//        if (pwd == null){
//            return UserEnums.EMPTY_PWD.getMessage();
//        }1.第一种，对每个属性所有错误情况写在主函数里

//        String nameMessage = checkName(name);
//        if (nameMessage != "Success"){
//            return nameMessage;
//        }
//        String pwdMessage = checkPwd(pwd);
//        if (pwdMessage != "Success"){
//            return pwdMessage;
//        }2.第二种，对每个属性单独用一个函数进行验错

        //Exception
        try {
            checkName(name);
            checkPwd(pwd);
            int status = userMapper.insertUser(name, pwd, realName);
            if (status != 1){
                throw new UserException(UserEnums.REGISTER_FAIL);
            }
        }catch (Exception e){
            return e.getMessage();
        }

        return "Successful Registion!";
    }

//    private String checkName(String name){
//        if (name == null){
//            return UserEnums.EMPTY_NAME.getMessage();
//        }
//        if (name.length() > 10){
//            return UserEnums.TOOLONG_NAME.getMessage();
//        }
//        return "Success";
//    }
//    private  String checkPwd(String pwd){
//        if (pwd == null){
//            return UserEnums.EMPTY_NAME.getMessage();
//        }
//        if (pwd.length() > 10){
//            return UserEnums.TOOLONG_NAME.getMessage();
//        }
//        return "Success";
//    }

    private void checkName(String name){
        if (name == null){
            throw new UserException(UserEnums.EMPTY_NAME);
        }
        if (name.length() > 10) {
            throw new UserException(UserEnums.TOOLONG_NAME);
        }
    }

    private void checkPwd(String pwd){
        if (pwd == null){
            throw new UserException(UserEnums.EMPTY_PWD);
        }
        if (pwd.length() > 10){
            throw new UserException(UserEnums.TOOLONG_PWD);
        }
    }

    public String changePwd(String name, String pwd, String newPwd){
        String gainPwd = userMapper.getPwd(name);
        if (gainPwd == null){
            //return "无用户";
            return UserEnums.NO_NAME.getMessage();
        }else if (gainPwd.equals(pwd)){
            int updateStatus = userMapper.updatePwd(name,newPwd);
            return "Success!";
        }else{
            //return "Can't Change!";
            return UserEnums.PWD_ERROR.getMessage();
        }


    }

}
