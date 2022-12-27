package com.example.project.schedule.service;


import com.example.project.group.repository.Group;
import com.example.project.schedule.dto.ScheduleDto;
import com.example.project.schedule.repository.ScheduleRepository;
import com.example.project.schedule.repository.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SchdServiceImpl implements SchdService{

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleDto> getScheduleInDate(Long userId, String startDate, String endDate) {
        return scheduleRepository.findAllScheduleInDate(userId, startDate, endDate)
                .stream().map(ScheduleDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleDto enrollSchedule(ScheduleDto dto, Group group) {
        Schedule entity = ScheduleDto.to(dto);
        entity.matchGroup(group);
        return ScheduleDto.from(scheduleRepository.save(entity));
    }
}
