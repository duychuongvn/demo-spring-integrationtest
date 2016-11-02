package com.github.duychuongvn.user.service;

import com.github.duychuongvn.exception.UserNotFoundException;
import com.github.duychuongvn.user.dao.entity.User;
import com.github.duychuongvn.user.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(String id) throws UserNotFoundException {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}
