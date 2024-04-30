package com.admin.service;

import com.admin.model.Product_details;
import com.admin.model.*;
import com.admin.dao.*;
import com.admin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductDAO productDAO;


    @Override
    public Product_details insert(Product_details productDetails) {
        if(!productDetails.getName().isEmpty()) {
            productDAO.insert(productDetails);
            return productDetails;
        }
        else
            throw new NullPointerException();
    }


    public Product findById(int id) {
        return productDAO.findById(id);
    }

    public void deleteById(int id) {
        productDAO.deleteById(id);
    }


    public Product_details update(Product_details productDetails) {
            //search for the related product if exist or not
            Product product = productDAO.findByProductDetails(productDetails);
            if (product != null)
            {
                productDAO.update(productDetails);
            }
            else
                throw new NullPointerException();
        return productDetails;
    }


    @Transactional
    public List<Product> getAllProducts() {
        try {
            return productDAO.getAllProducts();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Transactional
    public List<Product> findByName(String searchKey) {
        return productDAO.findByName(searchKey);
    }
}
