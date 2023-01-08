package com.example.project.group.service;

import com.example.project.common.error.ErrorCode;
import com.example.project.group.dto.GroupDto;
import com.example.project.group.repository.Group;
import com.example.project.group.repository.GroupRepository;
import com.example.project.user.repository.UserRepository;
import com.example.project.user.repository.domain.User;
import com.example.project.userandgroup.repository.MiddleEntityRepository;
import com.example.project.userandgroup.repository.MiddleEntityUserGroup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final MiddleEntityRepository middleEntityRepository;
    private final UserRepository userRepository;
    // Group 생성시 만든 유저 admin 설정
    @Transactional
    @Override
    public GroupDto createGroup(Long userId, GroupDto groupDto){
        Group group = Group.builder()
                .name(groupDto.getName())
                .build();

        Group groupEntity = groupRepository.save(group);
        User userEntity = userRepository.findByUserId(userId).orElseThrow(
                () -> new RuntimeException(ErrorCode.NOT_EXIST_USER.getMessage())
        );

        MiddleEntityUserGroup middleEntity = new MiddleEntityUserGroup(userEntity,groupEntity);
        userEntity.matchEntity(middleEntity);
        groupEntity.matchEntity(middleEntity);

        middleEntityRepository.save(middleEntity);
        log.info(groupEntity.toString());
        return GroupDto.builder()
                .name(groupEntity.getName())
                .participants(
                        groupEntity.getUsers().stream()
                                .map(v -> v.getUser().getEmail())
                                .collect(Collectors.toList())
                )
                .build();
    }

    //public Group createOrLoginGroup() {}


}

