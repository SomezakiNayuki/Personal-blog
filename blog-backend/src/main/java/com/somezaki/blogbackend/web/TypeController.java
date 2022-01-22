package com.somezaki.blogbackend.web;

import javax.validation.Valid;

import com.somezaki.blogbackend.po.Type;
import com.somezaki.blogbackend.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(
            @PageableDefault(size = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
            Model model) {
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "delete success");
        return "redirect:/admin/types";
    }

    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes) {

        Type t = typeService.getTypeByName(type.getName());

        if (t != null) {
            result.rejectValue("name", "nameError", "class duplication not allowed");
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        Type tt = typeService.saveType(type);

        if (tt == null) {
            attributes.addFlashAttribute("message", "operation failed");
        } else {
            attributes.addFlashAttribute("message", "operation success");
        }

        return "redirect:/admin/types";

    }

    @PostMapping("/types/{id}")
    public String editpost(@Valid Type type, BindingResult result, @PathVariable Long id,
            RedirectAttributes attributes) {

        Type t = typeService.getTypeByName(type.getName());

        if (t != null) {
            result.rejectValue("name", "nameError", "class duplication not allowed");
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        Type tt = typeService.updateType(id, type);

        if (tt == null) {
            attributes.addFlashAttribute("message", "operation failed");
        } else {
            attributes.addFlashAttribute("message", "operation success");
        }

        return "redirect:/admin/types";

    }

}
