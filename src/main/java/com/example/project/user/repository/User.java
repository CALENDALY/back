package com.example.project.user.repository;

import com.example.project.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "myUser")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userEmail;
    private String accessToken;
    @Enumerated(value = EnumType.STRING)
    private SNSType snsType;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    public void enrollEmail(String email) {
        this.userEmail = email;
    }
}
