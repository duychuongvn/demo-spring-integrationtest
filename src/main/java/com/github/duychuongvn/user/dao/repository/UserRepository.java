package com.github.duychuongvn.user.dao.repository;

import com.github.duychuongvn.user.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huynhduychuong on 11/2/2016.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
