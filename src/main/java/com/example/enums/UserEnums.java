package com.example.enums;

public enum UserEnums {
    SYSTEM_ERROR(0, "系统异常"),
    PWD_ERROR(1,"密码错误"),
    EMPTY_NAME(2, "用户名为空"),
    EMPTY_PWD(3, "密码为空"),
    NO_NAME(4,"无此用户"),
    REGISTER_FAIL(5, "注册失败"),
    TOOLONG_NAME(6,"用户名过长"),
    TOOLONG_PWD(7, "密码过长"),
    CART_WRONG(8, "创建购物车失败"),
    AMOUNTCHANGE_WRONG(9,"修改购物车内商品数量失败"),
    CUTITEM_WRONG(10, "删除购物车内商品失败")
    ;

    private int code;
    private String message;

    UserEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
