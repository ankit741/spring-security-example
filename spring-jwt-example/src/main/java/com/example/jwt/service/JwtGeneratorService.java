package com.example.jwt.service;

import com.example.jwt.model.User;
import java.util.Map;

public interface JwtGeneratorService {

  Map<String, String> generateToken(User user);
}
