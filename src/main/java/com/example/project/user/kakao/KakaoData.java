package com.example.project.user.kakao;

public record KakaoData(String id, KakaoAccount kakao_account) {

    record KakaoAccount(String nickname, String email, Profile profile){

    }

    record Profile(String nickname, String thumbnail_image_url){

    }
}
