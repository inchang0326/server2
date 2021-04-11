package com.example.server2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
public class JasyptController {

    @Value("${db.password}")
    String pw;

    @PostConstruct
    void init() {
        System.out.println(pw);
    }
    /*
        @Controller - @RequestMapping 은 view(jsp, html 등)를 요구한다. 따라서 view가 없다면, 404 error를 나타낼 것이다.
        그러므로 view 없이 String 값만 보여주고 싶다면, @Controller - @RequestMapping + @ResponseBody를 사용해야 한다.
        SpringBoot는 이것을 @RestController로 쉽게 구현하였다.
     */

    @RequestMapping(value = "/pw", method = RequestMethod.GET)
    @ResponseBody
    public String getPW() {
        return pw;
    }
}
