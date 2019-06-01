package com.busyqa.course.controller;

import com.busyqa.course.pojo.Greeting;
import com.busyqa.course.pojo.VAMPojo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HTMLModelViewController {


    @RequestMapping(method = RequestMethod.GET, value = "/ControllerPath1")
    public String controllMethod1(VAMPojo pojo, Model model) {

        // add something to model. Latter it will be showed on view
        model.addAttribute("model_attribute_name", "just add something");

        return "vam/VAMView";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ControllerPath2")
    public String controllMethod2(Model model, VAMPojo pojo) {
        System.out.println(pojo.getStrTest());

        // add whatever from http_get. Latter it will be showed on view
        model.addAttribute("model_attribute_name", pojo.getStrTest());

        return "vam/VAMView";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ControllerPath3")
    public String controllMethod3(VAMPojo pojo, Model model) {
        System.out.println(pojo.getStrTest());


        // add whatever from http_get to model. Latter it will be showed on view
        model.addAttribute("model_attribute_name", pojo.getStrTest());

        return "vam/VAMView";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ControllerPath4")
    public ModelAndView controllMethod41(VAMPojo pojo) {
        System.out.println(pojo.getStrTest());

        // create a ModelAndView Pare
        ModelAndView mav = new ModelAndView("vam/VAMView");

        // add what get from http_get to model. Latter it will be showed on view
        mav.addObject("model_attribute_name", pojo.getStrTest());

        return mav;
    }

    // same path but different http method
    @RequestMapping(method = RequestMethod.POST, value = "/ControllerPath4")
    public ModelAndView controllMethod42(VAMPojo pojo) {
        System.out.println(pojo.getStrTest());

        // create a ModelAndView Pare
        ModelAndView mav = new ModelAndView("vam/VAMView");

        // add what get from http_get to model. Latter it will be showed on view
        mav.addObject("model_attribute_name", pojo.getStrTest());

        return mav;
    }

    // ======== @ModelAttribute
    @RequestMapping(method = RequestMethod.GET, value = "/ControllerPath5")
    public String ControllerPath5(@ModelAttribute VAMPojo pojo) {
        System.out.println(pojo.getStrTest());
        return "vam/VAMView";
    }

    @GetMapping("/ControllerPath6")
    public String ControllerPath6(VAMPojo pojo, Map<String, Object> model) {
        System.out.println("get: " + pojo.getStrTest());
        model.put("model_attribute_name", pojo.getStrTest());
        return "vam/VAMView";
    }

    //================================================================
    @GetMapping("/msg")
    public String greetingForm() {
        return "vam/MsgForm";
    }

    @GetMapping("/sendmsg")
    public String getMsg(Greeting greeting, Model model) {
        System.out.println("get: " + greeting.getContent());
        model.addAttribute("greeting", greeting);
        return "vam/MsgResponse";
    }

    @PostMapping("/sendmsg")
    public String postMsg(@ModelAttribute Greeting greeting) {
        System.out.println("post: " + greeting.getContent());
        return "vam/MsgResponse";
    }


}
