package com.somezaki.blogbackend.dao;

import com.somezaki.blogbackend.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    public Tag findByName(String name);

}
