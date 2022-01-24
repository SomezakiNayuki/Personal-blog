package com.somezaki.blogbackend.service;

import java.util.List;

import com.somezaki.blogbackend.dao.TypeRepository;
import com.somezaki.blogbackend.exception.NotFoundException;
import com.somezaki.blogbackend.po.Type;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeServiceImp implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    public Type getType(Long id) {
        return typeRepository.getById(id);
    }

    @Transactional
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Transactional
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Transactional
    public Type updateType(Long id, Type type) {

        Type t = typeRepository.getById(id);

        if (t == null) {
            throw new NotFoundException("class not exist");
        }

        BeanUtils.copyProperties(type, t);

        return typeRepository.save(t);

    }

    @Transactional
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

}
