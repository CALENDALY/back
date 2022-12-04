package com.example.project.user.service;

import com.example.project.user.repository.User;
import com.example.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    @Transactional
    public User createUser(String email) {
        User user = new User();
        user.enrollEmail(email);
        repository.save(user);
        return repository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(String modifyEmail) {

        // JPA - Dirty check
        User user = repository.findById(1L).get();
        user.setUserEmail(modifyEmail);

        return null;
    }
}
