package com.example.jwt.controller;

import com.example.jwt.exception.UserNotFoundException;
import com.example.jwt.model.User;
import com.example.jwt.service.JwtGeneratorService;
import com.example.jwt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

  private UserServiceImpl userService;

  private JwtGeneratorService jwtGenerator;

  @Autowired
  public UserController(UserServiceImpl userService, JwtGeneratorService jwtGenerator) {
    this.userService = userService;
    this.jwtGenerator = jwtGenerator;
  }

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody User user) {
    try {
      if (user.getUserName() == null || user.getPassword() == null) {
        throw new UserNotFoundException("UserName or Password is Empty");
      }
      User userData = userService.getUserByNameAndPassword(user.getUserName(), user.getPassword());
      if (userData == null) {
        throw new UserNotFoundException("user name or password is invalid");
      }
      return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
    } catch (UserNotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }
}
