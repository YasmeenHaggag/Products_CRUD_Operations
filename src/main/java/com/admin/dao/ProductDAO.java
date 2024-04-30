package com.admin.dao;

import com.admin.dao.*;
import com.admin.model.*;


import java.util.List;

public interface ProductDAO
{
    Product insert(Product_details product);
    Product findById(int id);
    Product findByProductDetails(Product_details productDetails);
    void deleteById(int id);

   // Product_details showProduct(int id);
    void update(Product_details product);
    List<Product> getAllProducts();

    List<Product> findByName(String searchKey);
}
