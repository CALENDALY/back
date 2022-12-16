package com.example.project.user.service;

import com.example.project.user.kakao.KakaoData;
import com.example.project.user.repository.domain.SNSType;
import com.example.project.user.repository.domain.User;
import com.example.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    @Transactional
    public User createOrLoginUser(KakaoData.KakaoAccount account, String accessToken, SNSType type) {
        Optional<User> userCheck = repository.findByUserEmailAndSnsType(account.email(), type);
        if(userCheck.isPresent()){
            return userCheck.get();
        }

        User user = User.builder()
                .email(account.email())
                .nickName(account.profile().nickname())
                .snsType(type)
                .imageUrl(account.profile().thumbnail_image_url())
                .accessToken(accessToken)
                .build();

        repository.save(user);
        return repository.save(user);
    }

    @Override
    @Transactional
    public User updateAccessToken(String email, SNSType snsType, String accessToken) {

        // JPA - Dirty check
        User user = repository.findByUserEmailAndSnsType(email, snsType)
                .orElseThrow(() -> new IllegalArgumentException("에러"));

        user.updateToken(accessToken);

        return user;
    }
}
