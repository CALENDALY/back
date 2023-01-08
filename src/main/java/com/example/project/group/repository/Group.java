package com.example.project.group.repository;

import com.example.project.common.BaseEntity;
import com.example.project.userandgroup.repository.MiddleEntityUserGroup;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MY_GROUP")
@Builder
@Setter
@ToString
public class Group extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "group")
    private List<MiddleEntityUserGroup> users = new ArrayList<>();

    @Override
    public void onPrePersist() {
        super.onPrePersist();
        users = new ArrayList<>();
    }

    public void matchEntity(MiddleEntityUserGroup middleEntityUserGroup){
        middleEntityUserGroup.setGroup(this);
        this.users.add(middleEntityUserGroup);
    }
}
