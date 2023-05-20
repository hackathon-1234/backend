package com.hackathon2.auth.service;

import com.hackathon2.auth.data.User;
import com.hackathon2.auth.data.UserPrincipal;
import com.hackathon2.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }

    public void createUser(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        User user = new User(username, encoder.encode(password), false);
        userRepository.save(user);
    }
}
