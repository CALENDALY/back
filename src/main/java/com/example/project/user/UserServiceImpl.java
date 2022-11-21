package com.example.project.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public User createUser(String email) {
        User user = new User();
        user.setUserEmail(email);
        return repository.save(user);
    }
}
