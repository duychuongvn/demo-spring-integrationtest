package com.github.duychuongvn.user.service;

import com.github.duychuongvn.exception.UserNotFoundException;
import com.github.duychuongvn.user.dao.entity.User;


public interface UserService {

    User findById(String id) throws UserNotFoundException;
}
