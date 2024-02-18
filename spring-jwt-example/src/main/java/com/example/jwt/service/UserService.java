package com.example.jwt.service;

import com.example.jwt.model.User;

public interface UserService {

  public User getUserByNameAndPassword(String userName, String password);
}
