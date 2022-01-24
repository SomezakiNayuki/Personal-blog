package com.somezaki.blogbackend.service;

import com.somezaki.blogbackend.po.Blog;
import com.somezaki.blogbackend.vo.BlogQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    public Blog getBlog(Long id);

    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    public Blog saveBlog(Blog blog);

    public Blog updateBlog(Long id, Blog blog);

    public void deleteBlog(Long id);

}
