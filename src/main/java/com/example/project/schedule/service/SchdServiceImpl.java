package com.example.project.schedule.service;


import com.example.project.group.repository.Group;
import com.example.project.group.repository.GroupRepository;
import com.example.project.schedule.dto.ScheduleDto;
import com.example.project.schedule.repository.ScheduleRepository;
import com.example.project.schedule.repository.domain.Schedule;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class SchdServiceImpl implements SchdService{

    private final ScheduleRepository scheduleRepository;
    private final GroupRepository groupRepository;
    @Override
    public List<ScheduleDto> getScheduleInDate(Long groupId, String startDate, String endDate) {
        if(isBlank(startDate) && isBlank(endDate)){
            log.info("is empty {} {}", startDate, endDate);
            return scheduleRepository.findByGroupId(groupId)
                    .stream().map(v -> {
                        ScheduleDto dto = ScheduleDto.from(v);
                        dto.setGroupId(v.getGroup().getId());
                        return dto;
                    })
                    .collect(Collectors.toList());
        }
        log.info("is not empty {} {}", startDate, endDate);
        return scheduleRepository.findAllScheduleInDate(groupId, startDate, endDate)
                .stream().map(v -> {
                    ScheduleDto dto = ScheduleDto.from(v);
                    dto.setGroupId(v.getGroup().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleDto enrollSchedule(ScheduleDto dto, Long groupId) {
        Schedule entity = ScheduleDto.to(dto);
        entity.matchGroup(groupRepository.findById(groupId).get());
        return ScheduleDto.from(scheduleRepository.save(entity));
    }

    @Override
    public ScheduleDto delete(Long schdId) {
        Schedule schedule = scheduleRepository.findById(schdId)
                .orElseThrow(() -> new RuntimeException("없는 스케쥴 아이디 입니다."));
        scheduleRepository.delete(schedule);
        return ScheduleDto.from(schedule);
    }

    private boolean isBlank(String s){
        return s == null || "".equals(s);
    }
}
