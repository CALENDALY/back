package com.example.project.userandgroup.repository;

import com.example.project.common.BaseEntity;
import com.example.project.group.repository.Group;
import com.example.project.user.repository.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Lazy;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MiddleEntityUserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    public MiddleEntityUserGroup(User user, Group group) {
        this.user = user;
        this.group = group;
        user.matchEntity(this);
        group.matchEntity(this);
    }
    public void setUser(User user){
        this.user = user;
    }
    public void setGroup(Group group){
        this.group = group;
    }
}
