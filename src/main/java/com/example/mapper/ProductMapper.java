package com.example.mapper;


import com.example.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductMapper {
    ArrayList<Product> getAllProducts();
}
