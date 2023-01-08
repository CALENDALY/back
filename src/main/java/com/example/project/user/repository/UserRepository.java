package com.example.project.user.repository;

import com.example.project.user.repository.domain.SNSType;
import com.example.project.user.repository.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select u from User u where u.userId = :userId")
    Optional<User> findByUserId(Long userId);
    @Query(value = "select u from User u where u.email = :email and u.snsType = :snsType")
    Optional<User> findByUserEmailAndSnsType(String email, SNSType snsType);
}
