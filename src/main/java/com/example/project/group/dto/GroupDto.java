package com.example.project.group.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class GroupDto {
    private String name;

    private List<String> participants;
}
