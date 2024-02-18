import React from "react";
import 'font-awesome/css/font-awesome.min.css';
import "./login.css";
export default function Login() {
  return (
    <div class="container">
      <h2>Sign in</h2>
      <form class="login-form">
        <div class="social-container">
          <a href="#">
            <i class="fa fa-google"></i>
          </a>
          <a href="#">
            <i class="fa fa-github"></i>
          </a>
          <a href="#">
            <i class="fa fa-twitter"></i>
          </a>
          <h3>or use your account</h3>
        </div>
        <label>Username</label>
        <input type="text" id="user_name" class="input"></input>
        <label>Password</label>
        <input type="password" id="password" class="input"></input>
        <button type="submit" id="submit" class="button">
          Login
        </button>
      </form>
    </div>
  );
}
