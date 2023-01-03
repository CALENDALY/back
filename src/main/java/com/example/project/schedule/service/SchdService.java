package com.example.project.schedule.service;

import com.example.project.schedule.dto.ScheduleDto;

import java.util.List;

public interface SchdService {
    List<ScheduleDto> getScheduleInDate(Long userId, String startDate, String endDate);
    ScheduleDto enrollSchedule(ScheduleDto dto, Long groupId);

    ScheduleDto delete(Long schdId);
}
