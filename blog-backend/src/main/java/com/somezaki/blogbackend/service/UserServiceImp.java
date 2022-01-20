package com.somezaki.blogbackend.service;

import com.somezaki.blogbackend.dao.UserRepository;
import com.somezaki.blogbackend.po.User;
import com.somezaki.blogbackend.util.MD5Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

}
