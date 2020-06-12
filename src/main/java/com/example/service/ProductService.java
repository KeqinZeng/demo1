package com.example.service;

import com.example.entity.Product;
import com.example.enums.UserEnums;
import com.example.mapper.ProductMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public ArrayList<Product> getAllProducts(){
        return productMapper.getAllProducts();
    }

    public Product getAProduct(int productId){
        //return productMapper.getAProduct(productId).toString();
        return productMapper.getAProduct(productId);
    }

}
