package com.example.jwt.service;

import com.example.jwt.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  public User getUserByNameAndPassword(String userName, String password) {
    return new User("admin","admin123");
  }
}
