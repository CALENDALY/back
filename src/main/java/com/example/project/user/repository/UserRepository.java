package com.example.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select u from User u where u.userId = :userId")
    Optional<User> findByUserId(String userId);
    @Query(value = "select u from User u where u.email = :email and u.snsType = :snsType")
    Optional<User> findByUserEmailAndSnsType(String email, SNSType snsType);
}
