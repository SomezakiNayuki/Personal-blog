package com.somezaki.blogbackend.service;

import com.somezaki.blogbackend.po.Type;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {

    public Type saveType(Type type);

    public Type getType(Long id);

    public Type getTypeByName(String name);

    public Page<Type> listType(Pageable pageable);

    public Type updateType(Long id, Type type);

    public void deleteType(Long id);

}
