package com.example.project.group.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GroupDto {
    private Long id;
    private String name;
    private List<String> userId = new ArrayList<>();
}
