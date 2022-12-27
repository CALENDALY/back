package com.example.project.group.repository;

import com.example.project.common.BaseEntity;
import com.example.project.userandgroup.repository.MiddleEntityUserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MY_GROUP")
public class Group extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "group")
    private List<MiddleEntityUserGroup> users = new ArrayList<>();
}
