package com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userService.entity.User;
public interface UserRepositry extends JpaRepository<User, String>{

}
