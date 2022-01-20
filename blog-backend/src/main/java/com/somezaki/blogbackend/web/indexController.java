package com.somezaki.blogbackend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    /*
     * @GetMapping("/{id}/{name}")
     * public String index(@PathVariable Integer id, @PathVariable String name) {
     * return "index";
     * }
     */

    @GetMapping("/")
    public String index(Integer id, String name) {
        return "index";
    }

    @GetMapping("/blog")
    public String blog(Integer id, String name) {
        return "blog";
    }

}
