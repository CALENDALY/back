package com.example.project.user.repository.domain;

public enum SNSType {
    KAKAO("KAKAO"),
    GOOGLE("GOOGLE");
    private String type;

    SNSType(String type) {
        this.type = type;
    }
}
