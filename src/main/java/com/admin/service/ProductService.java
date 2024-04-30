package com.admin.service;

import com.admin.model.*;

import java.util.List;


public interface ProductService
{
    Product_details insert(Product_details product);
    Product findById(int id);
    void deleteById(int id);
    Product_details update(Product_details product);
    List<Product> getAllProducts();

    List<Product> findByName(String searchKey);
}
