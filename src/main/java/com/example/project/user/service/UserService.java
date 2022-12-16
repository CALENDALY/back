package com.example.project.user.service;

import com.example.project.user.kakao.KakaoData;
import com.example.project.user.repository.SNSType;
import com.example.project.user.repository.User;
import org.hibernate.usertype.UserType;

public interface UserService {
    User createUser(KakaoData.KakaoAccount kakaoAccount, String accessToken, SNSType type);
    User updateAccessToken(String email, SNSType snsType, String accessToken);
}
