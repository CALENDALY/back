package com.example.project.user.service;

import com.example.project.user.kakao.KakaoData;
import com.example.project.user.repository.domain.SNSType;
import com.example.project.user.repository.domain.User;

public interface UserService {
    User createOrLoginUser(KakaoData.KakaoAccount kakaoAccount, String accessToken, SNSType type);
    User updateAccessToken(String email, SNSType snsType, String accessToken);
}
