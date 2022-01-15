package com.somezaki.blogbackend.web;

import com.somezaki.blogbackend.exception.NotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String index() {
        // int i = 9 / 0;
        String blog = null;
        if (blog == null) {
            throw new NotFoundException("blog do not exist");
        }
        return "index";
    }

}
