package com.example.project.group.controller;

import com.example.project.group.dto.GroupDto;
import com.example.project.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/{userId}")
    public ResponseEntity<GroupDto> test(@PathVariable String userId,  @RequestBody GroupDto groupDto){
        return ResponseEntity.ok(groupService.createGroup(userId, groupDto));
    }
}
