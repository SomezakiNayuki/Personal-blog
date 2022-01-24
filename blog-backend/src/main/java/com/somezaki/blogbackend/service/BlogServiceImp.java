package com.somezaki.blogbackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.somezaki.blogbackend.dao.BlogRepository;
import com.somezaki.blogbackend.exception.NotFoundException;
import com.somezaki.blogbackend.po.Blog;
import com.somezaki.blogbackend.po.Type;
import com.somezaki.blogbackend.vo.BlogQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImp implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog getBlog(Long id) {
        return blogRepository.getById(id);
    }

    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {

        return blogRepository.findAll(new Specification<Blog>() {

            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> criteriaQuery,
                    CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                    predicates.add(criteriaBuilder.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                }

                if (blog.getTypeId() != null) {
                    predicates.add(criteriaBuilder.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }

                if (blog.isRecommendation()) {
                    predicates.add(criteriaBuilder.equal(root.<Boolean>get("recommendation"), blog.isRecommendation()));
                }

                criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

                return null;

            }

        }, pageable);

    }

    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog blog) {

        Blog b = blogRepository.getById(id);

        if (b == null) {
            throw new NotFoundException("blog not exist");
        }

        BeanUtils.copyProperties(blog, b);

        return blogRepository.save(b);

    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

}
