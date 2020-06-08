package com.example.controller;


import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.mapper.UserMapper;
import com.example.service.ProductService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    //@Autowired
    //private ProductMapper productMapper;
    @Autowired
    private ProductService productService;

    //@RequestMapping("getAllProducts")
    @CrossOrigin(origins = "*")
    @RequestMapping(value="getAllProducts", method = RequestMethod.POST)
    public ArrayList<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}
