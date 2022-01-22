package com.somezaki.blogbackend.service;

import com.somezaki.blogbackend.dao.TagRepository;
import com.somezaki.blogbackend.exception.NotFoundException;
import com.somezaki.blogbackend.po.Tag;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagServiceImp implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    public Tag getTag(Long id) {
        return tagRepository.getById(id);
    }

    @Transactional
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    public Tag updateTag(Long id, Tag tag) {

        Tag t = tagRepository.getById(id);

        if (t == null) {
            throw new NotFoundException("tag not exist");
        }

        BeanUtils.copyProperties(tag, t);

        return tagRepository.save(t);

    }

    @Transactional
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

}
