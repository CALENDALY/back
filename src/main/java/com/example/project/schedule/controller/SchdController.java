package com.example.project.schedule.controller;

import com.example.project.group.service.GroupService;
import com.example.project.schedule.dto.ScheduleDto;
import com.example.project.schedule.service.SchdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schd")
@RequiredArgsConstructor
public class SchdController {

    private final SchdService service;
    private final GroupService groupService;
    @GetMapping("/{groupId}")
    public ResponseEntity<List<ScheduleDto>> getSchds(@PathVariable Long groupId,@RequestBody RequestSchd.GetDate request){
        return ResponseEntity.ok(service.getScheduleInDate(groupId, request.startDate(), request.endDate()));
    }

    @PostMapping("/{groupId}")
    public ResponseEntity<ScheduleDto> enrollSchd(@PathVariable Long groupId, @RequestBody RequestSchd.EnrollSchd request){
        ScheduleDto dto = ScheduleDto.builder()
                .subject(request.subject())
                .contents(request.contents())
                .startDt(request.startDt())
                .endDt(request.endDt())
                .build();
        return ResponseEntity.ok(
                service.enrollSchedule(dto, groupId)
        );
    }

    @DeleteMapping("/{schdId}")
    public ResponseEntity<ScheduleDto> deleteSchd(@PathVariable Long schdId){
        return ResponseEntity.ok(
                service.delete(schdId)
        );
    }

}
