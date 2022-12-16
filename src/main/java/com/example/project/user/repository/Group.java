package com.example.project.user.repository;

import com.example.project.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Table(name = "groups")
public class Group extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<UserAndGroupMiddle> middle = new ArrayList<>();

}
