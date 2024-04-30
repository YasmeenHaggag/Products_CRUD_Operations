package com.admin.dao;

import com.admin.dao.*;
import com.admin.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO
{
    @Autowired
    public SessionFactory sessionFactory;


    @Override
    public Product insert(Product_details productDetails) {
        try {
            Session session = sessionFactory.getCurrentSession();
            productDetails.setExpiration(productDetails.getExpiration());

            Product product = new Product(productDetails.getName());
            product.setProductDetails(productDetails);
            session.persist(product);
            return product;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.get(Product.class , id);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }


    public Product findByProductDetails(Product_details productDetails) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Product_details productDetails2  = session.get(Product_details.class , productDetails.getId());
            return productDetails2.getProduct();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    public void deleteById(int theId) {

        //second implementation fo the delete method to delete product and product details
        try {
            Session session = sessionFactory.getCurrentSession();
            Product product = session.get(Product.class , theId);

            //to delete the product
            Query query = session.createQuery("delete from Product  where id=:productId");
            query.setParameter("productId" , theId);
            query.executeUpdate();

            //to delete the product details
             query = session.createQuery("delete from Product_details  where id=:productDetailsId");
            query.setParameter("productDetailsId" , product.getProductDetails().getId());
            query.executeUpdate();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Product_details newProduct) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Product_details oldProductDetails = session.get(Product_details.class , newProduct.getId());
            Product oldProduct = oldProductDetails.getProduct();
            oldProduct.setName(newProduct.getName());
            oldProductDetails.setName(newProduct.getName());
            oldProductDetails.setExpiration(newProduct.getExpiration());
            oldProductDetails.setManufacturer(newProduct.getManufacturer());
            oldProductDetails.setPrice(newProduct.getPrice());
//            oldProductDetails.setAvailability(newProduct.getAvailability());
            oldProductDetails.setProduct(newProduct.getProduct());
            oldProduct.setProductDetails(oldProductDetails);
            session.update(oldProduct);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public List<Product> getAllProducts() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("FROM Product");
            return (List<Product>) query.list();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    public List<Product> findByName(String searchKey) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where name=:productName");
        query.setParameter("productName" , searchKey);
        return query.list();
    }
}
