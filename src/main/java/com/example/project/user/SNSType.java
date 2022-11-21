package com.example.project.user;

public enum SNSType {
    KAKAO("KAKAO"),
    GOOGLE("GOOGLE");
    private String type;

    SNSType(String type) {
        this.type = type;
    }
}
