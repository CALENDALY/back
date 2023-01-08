package com.example.project.user.repository.domain;

import com.example.project.common.BaseEntity;
import com.example.project.userandgroup.repository.MiddleEntityUserGroup;
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

    @OneToMany(mappedBy = "user")
    private List<MiddleEntityUserGroup> groups = new ArrayList<>();

    @Builder
    public User(String accessToken, String email, String nickName, SNSType snsType, String imageUrl) {
        this.accessToken = accessToken;
        this.email = email;
        this.nickName = nickName;
        this.snsType = snsType;
        this.imageUrl = imageUrl;
    }

    public void updateToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public void onPrePersist() {
        super.onPrePersist();
        groups = new ArrayList<>();
    }

    public void matchEntity(MiddleEntityUserGroup middleEntityUserGroup){
        middleEntityUserGroup.setUser(this);
        this.groups.add(middleEntityUserGroup);
    }
}
