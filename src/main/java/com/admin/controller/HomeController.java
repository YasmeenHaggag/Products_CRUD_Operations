package com.admin.controller;
import com.admin.model.Product;
import com.admin.model.Product_details;
import com.admin.model.Student;
import com.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class HomeController{

@Autowired
ProductService productService;

    @RequestMapping( value = "/")
    public String showHomePage(Model productModel) throws ParseException {
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList" , productList);
        return "homePage";
    }

    @RequestMapping( value = "addProduct")
    public String addProduct(Model productModel) throws ParseException {
        return "addProduct";
    }


//    @RequestMapping("/addproduct")
//    public String addProduct(HttpServletRequest request,Model model) {
//        // model.addAttribute("userModel",new Persons());
//        Product product=productService.insert()
//        Product_details productDetails=product.setProductDetails();
//        productService.findById();
//        return ("addProduct");
//    }
    @GetMapping("/addProduct")
    public String showAddProduct(Model model)
    {
        model.addAttribute("productModel" , new Product_details());
        return "addProduct";
    }
    @PostMapping( "/processAddProduct" )
    public String processAddProduct(@ModelAttribute("productModel") Product_details productDetails , BindingResult bindingResult , Model productModel)
    {

        productService.insert(productDetails);
//        List<Product> productList = productService.getAllProducts();
//        productModel.addAttribute("productsList" , productList);
        return "redirect:/";
    }


  @GetMapping("deleteProduct")
  public String delete(@RequestParam("productId") int id){
        productService.deleteById(id);
        return "redirect:/";
    }



    @GetMapping("/updateProduct")
        public String update(@RequestParam("productId") int id ,  Model model)
        {
            //get the product related to the id
            Product product = productService.findById(id);

            //set the product details related to the product with the id and add it to the model
            Product_details productDetails = product.getProductDetails();
            productDetails.setProduct(product);
            model.addAttribute("productModel" , productDetails);
            return "updateProduct";
    }

    @PostMapping( "/processUpdateProduct" )
    public String processUpdateProduct(@ModelAttribute("productModel") Product_details productDetails ,  Model productModel)
    {
        productService.update(productDetails);
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productsList" , productList);
        return "redirect:/";
    }

    @GetMapping("/showDetails")
    public String showProductDetails(@RequestParam("productId") int id ,  Model model) {

        //get the product related to the id
        Product product = productService.findById(id);

        //set the product details related to the product with the id and add it to the model
        Product_details productDetails = product.getProductDetails();
        productDetails.setProduct(product);
        model.addAttribute("productModel" , productDetails);
        return "showDetails";
    }

        @InitBinder
    public void InitBinder(WebDataBinder binder){
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yy");
            binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));

    }

//    @RequestMapping("/addproduct")
//    public String addProduct(@ModelAttribute("addProduct") Products products, HttpServletRequest request,Model model)
//    {
//        model.addAttribute("addProductobj",products);
//        //System.out.println(products.getProductName());
//        return("addproduct");
//    }





//

}



