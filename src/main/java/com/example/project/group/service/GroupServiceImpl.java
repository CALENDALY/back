package com.example.project.group.service;

import com.example.project.group.repository.GroupRepository;
import com.example.project.group.dto.GroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;

    @Override
    public List<GroupDto> getGroupData(Long groupId) {


        return null;
    }

}
