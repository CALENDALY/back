package com.example.project.user.service;

import com.example.project.user.repository.User;

public interface UserService {
    User createUser(String email);
    User updateUser(String email);
}
