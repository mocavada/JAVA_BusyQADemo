package com.busyqa.course.controller;

import com.busyqa.course.pojo.CurrencyRate;
import com.busyqa.course.pojo.Product;
import com.busyqa.course.pojo.ProductType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class MustacheController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/ProductInfoMustache.html")
    public ModelAndView ProductInfoM() {
        Product product1 = new Product("Cellphone", 1200, new Date(), ProductType.BUSINESS);
        Product product2 = new Product("Laptop", 750, new Date(), ProductType.HOME);
        Product product3 = new Product("Desktop", 150, new Date(), ProductType.GAME);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        Map<String, Object> params = new HashMap<>();
        params.put("product", productList);
        params.put("messageContent", "Mustache is ez.");

        return new ModelAndView("ProductInfoMustache", params);
    }

    @RequestMapping("/forex.html")
    public String handleRequest(Model model) {
        model.addAttribute("todayCurrencyRates", getTodayForexRates());
        return "forex-view";
    }

    private List<CurrencyRate> getTodayForexRates() {
        //dummy rates
        List<CurrencyRate> currencyRates = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();
        List<Currency> currencies = new ArrayList<>(Currency.getAvailableCurrencies());

        for (int i = 0; i < currencies.size() - 1; i += 2) {
            String currencyPair = currencies.get(i) + "/" + currencies.get(i + 1);
            CurrencyRate cr = new CurrencyRate();
            cr.setCurrencyPair(currencyPair);
            cr.setDateTime(today);
            BigDecimal bidPrice = new BigDecimal(Math.random() * 5 + 1);
            bidPrice = bidPrice.setScale(3, RoundingMode.CEILING);
            cr.setBidPrice(bidPrice);
            BigDecimal askPrice = new BigDecimal(bidPrice.doubleValue() + Math.random() * 2 + 0.5);
            askPrice = askPrice.setScale(3, RoundingMode.CEILING);
            cr.setAskPrice(askPrice);
            currencyRates.add(cr);
        }
        return currencyRates;
    }

}

