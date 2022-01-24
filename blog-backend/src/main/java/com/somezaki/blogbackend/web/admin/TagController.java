package com.somezaki.blogbackend.web.admin;

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

import javax.validation.Valid;

import com.somezaki.blogbackend.po.Tag;
import com.somezaki.blogbackend.service.TagService;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
            Model model) {
        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "delete success");
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {

        Tag t = tagService.getTagByName(tag.getName());

        if (t != null) {
            result.rejectValue("name", "nameError", "tag duplication not allowed");
        }

        if (result.hasErrors()) {
            return "admin/tags-input";
        }

        Tag tt = tagService.saveTag(tag);

        if (tt == null) {
            attributes.addFlashAttribute("message", "operation failed");
        } else {
            attributes.addFlashAttribute("message", "operation success");
        }

        return "redirect:/admin/tags";

    }

    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult result, @PathVariable Long id,
            RedirectAttributes attributes) {

        Tag t = tagService.getTagByName(tag.getName());

        if (t != null) {
            result.rejectValue("name", "nameError", "tag duplication not allowed");
        }

        if (result.hasErrors()) {
            return "admin/tags-input";
        }

        Tag tt = tagService.updateTag(id, tag);

        if (tt == null) {
            attributes.addFlashAttribute("message", "operation failed");
        } else {
            attributes.addFlashAttribute("message", "operation success");
        }

        return "redirect:/admin/tags";

    }

}