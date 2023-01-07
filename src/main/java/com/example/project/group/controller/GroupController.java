package com.example.project.group.controller;

import com.example.project.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
}
