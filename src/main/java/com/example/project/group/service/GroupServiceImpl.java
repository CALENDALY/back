package com.example.project.group.service;

import com.example.project.group.dto.GroupDto;
import com.example.project.group.repository.Group;
import com.example.project.group.repository.GroupRepository;
import com.example.project.user.repository.UserRepository;
import com.example.project.user.repository.domain.User;
import com.example.project.userandgroup.repository.MiddleEntityRepository;
import com.example.project.userandgroup.repository.MiddleEntityUserGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final MiddleEntityRepository middleEntityRepository;
    private final UserRepository userRepository;
    // Group 생성시 만든 유저 admin 설정
    @Transactional
    @Override
    public GroupDto createGroup(String userId, GroupDto groupDto){
        Group group = Group.builder()
                .groupName(groupDto.getGroupName())
                .build();
        Group groupEntity = groupRepository.save(group);
        User userEntity = userRepository.findByUserId(userId).get();

        MiddleEntityUserGroup middleEntity = new MiddleEntityUserGroup(userEntity,groupEntity);
        middleEntityRepository.save(middleEntity);

        return GroupDto.builder()
                .groupName(groupEntity.getGroupName())
                .participants(
                        groupEntity.getUsers().stream()
                                .map(v -> v.getUser().getEmail())
                                .collect(Collectors.toList())
                )
                .build();
    }

    //public Group createOrLoginGroup() {}


}

