package com.example.project.group.service;


import com.example.project.group.dto.GroupDto;

public interface GroupService {
    GroupDto createGroup(String userId, GroupDto groupDto);

}
