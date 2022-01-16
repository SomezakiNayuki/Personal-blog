package com.somezaki.blogbackend.web;

import com.somezaki.blogbackend.exception.NotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String index() {
        // int i = 9 / 0;
        throw new NotFoundException("blog do not exist");
    }

}
