package com.example.jwt.service;

import com.example.jwt.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtGeneratorServiceImpl implements JwtGeneratorService {
  @Value("${jwt.secret}")
  private String secret;
  @Value("${jwt.message}")
  private String message;
  @Override
  public Map<String, String> generateToken(User user) {
    String jwtToken="";
    jwtToken = Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date()).signWith(
        SignatureAlgorithm.HS256, "secret").compact();
    Map<String, String> jwtTokenGen = new HashMap<>();
    jwtTokenGen.put("token", jwtToken);
    jwtTokenGen.put("message", message);
    return jwtTokenGen;
  }
}
