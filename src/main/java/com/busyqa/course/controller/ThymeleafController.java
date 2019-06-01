package com.busyqa.course.controller;

import com.busyqa.course.pojo.*;
import com.busyqa.course.service.CityDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class ThymeleafController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "/anotherpage")
    public String welcome(Map<String, Object> model) {
        model.put("messageContent", "Welcome to our grocery store!");
        return "thymeleaf/Welcome";
    }

    //========
    // http://127.0.0.1/ProductInfo
    @GetMapping("/ProductInfo")
    public String productInfo(Map<String, Object> model) {
        Product product = new Product(
                "Wooden wardrobe with glass doors",
                850, new Date(),
                ProductType.BUSINESS);

        model.put("product", product);
        return "thymeleaf/ProductInfo";
    }

    // http://127.0.0.1/ProductInfoInternational
    @RequestMapping("/ProductInfoInternational")
    public String productInfo18(Map<String, Object> model) {
        Product product = new Product("Wooden wardrobe with glass doors", 850, new Date(), ProductType.BUSINESS);
        model.put("product", product);
        return "thymeleaf/ProductInfoInternational";
    }

    //========
    // http://127.0.0.1/ProductInfoList
    @RequestMapping("/ProductInfoList")
    public String productList(Map<String, Object> model) {
        Product product1 = new Product("Cellphone", 1200, new Date(), ProductType.BUSINESS);
        Product product2 = new Product("Laptop", 750, new Date(), ProductType.HOME);
        Product product3 = new Product("Desktop", 150, new Date(), ProductType.GAME);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        model.put("productListKey", productList);
        return "thymeleaf/ProductInfoList";
    }

    @RequestMapping("/ProductInfoForm")
    public String productForm(Map<String, Object> model) {
        Product product = new Product("Wooden wardrobe with glass doors", 850, new Date(), ProductType.BUSINESS);
        model.put("product", product);
        return "ProductInfoForm";
    }

    //========
    @RequestMapping("/ProductInfoFragment")
    public String productFragment(Map<String, Object> model) {
        return "thymeleaf/ProductInfoFragment";
    }

    @RequestMapping("/ProductInfoComments")
    public String productFragmentComments(Map<String, Object> model) {
        return "thymeleaf/ProductInfoComments";
    }





}

