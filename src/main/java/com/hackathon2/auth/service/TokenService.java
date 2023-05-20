package com.hackathon2.auth.service;

import com.hackathon2.auth.data.User;
import com.hackathon2.auth.data.UserInfo;

public interface TokenService {
    String generateToken(User user);

    UserInfo parseToken(String token);
}
