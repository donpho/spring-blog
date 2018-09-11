package com.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public int addNumbers(
            @PathVariable int num1,
            @PathVariable int num2
    ){
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtractNumbers(
            @PathVariable int num1,
            @PathVariable int num2
    ){
        return num2 - num1;
    }

    @GetMapping("/multiple/{num1}/and/{num2")
    @ResponseBody
    public int multiplyNumbers(
            @PathVariable int num1,
            @PathVariable int num2
    ){
        return num1*num2;
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divideNumbers(
            @PathVariable int num1,
            @PathVariable int num2
    ){
        if(num2 == 0){
            return "Sorry, but we cannot divide by 0!";
        }
        return ""+ (num1 / num2);
    }

}
