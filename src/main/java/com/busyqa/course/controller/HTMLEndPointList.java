package com.busyqa.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class HTMLEndPointList {
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    public void EndpointDocController(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @RequestMapping(value = "/endpointdoc", method = RequestMethod.GET)
    public void show(Model model) {

        ArrayList<String> urlList = new ArrayList<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> item : this.handlerMapping.getHandlerMethods().entrySet()) {
            urlList.add(item.getKey().getPatternsCondition().toString()
                    .replace("[", "").replace("]", ""));
        }
        model.addAttribute("handlerMethods", urlList);
    }

}
