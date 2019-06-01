package com.busyqa.project.shoppingcart;

import com.busyqa.project.shoppingcart.service.ShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ShoppingCartController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ShoppingService shoppingService;

    //========
    @GetMapping("/showMyShoppingCart.html")
    public String showMyShoppingCart(Map<String, Object> model) {

        model.put("shoppingCart", shoppingService.getMyShoppingCart());

        return "project/showMyShoppingCart";
    }

    @GetMapping("/showMyShoppingCartFromBean.html")
    public String showMyShoppingCartFromBean(Map<String, Object> model) {

        model.put("shoppingCart", shoppingService.getMyShoppingCartFromBean());

        return "project/showMyShoppingCart";
    }
}

