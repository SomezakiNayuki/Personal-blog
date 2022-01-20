package com.somezaki.blogbackend.service;

import com.somezaki.blogbackend.po.User;

public interface UserService {

    User checkUser(String username, String password);

}
