package com.example.project.user.repository;

import com.example.project.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "myUser")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String accessToken;
    private String email;
    private String nickName;
    @Enumerated(value = EnumType.STRING)
    private SNSType snsType;
    private String imageUrl;

    @Builder
    public User(String accessToken, String email, String nickName, SNSType snsType, String imageUrl) {
        this.accessToken = accessToken;
        this.email = email;
        this.nickName = nickName;
        this.snsType = snsType;
        this.imageUrl = imageUrl;
    }

    @OneToMany(mappedBy = "user")
    private List<UserAndGroupMiddle> groups = new ArrayList<>();

    public void updateToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
