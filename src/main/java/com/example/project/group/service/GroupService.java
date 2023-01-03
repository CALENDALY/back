package com.example.project.group.service;

import com.example.project.group.dto.GroupDto;

import java.util.List;

public interface GroupService {
    List<GroupDto> getGroupData(Long groupId);
}
