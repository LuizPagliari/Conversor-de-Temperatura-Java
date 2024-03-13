package com.vntCalc.Calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
	
    @GetMapping("/")
    public ModelAndView calculator (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculator");
        return modelAndView;
    }       
        
    @PostMapping("/calculate")
    public String calculate(@RequestParam("num1") double num1,
                            @RequestParam("operator") String operator,
                            Model model) {
        double result=0;
        switch (operator) {
            case "K>C":
                result = num1-273.15;
                break;
            case "K>F":
                result = (num1-273.15)*1.8 + 32;
                break;
            case "C>K":
                result = num1+273.15;
                break;
            case "C>F":
                result = (num1* 1.8) + 32;
            case "F>C":
                result = (num1-32) / 1.8;
            case "F>K":
                result = (num1-32) * 5/9 + 273.15;
        }
        model.addAttribute("result", result);
        return "calculator";
    }
}