package com.somezaki.blogbackend.dao;

import com.somezaki.blogbackend.po.Type;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
