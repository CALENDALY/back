package com.example.project.schedule.dto;

import com.example.project.schedule.repository.domain.Schedule;
import lombok.Builder;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@Builder
public class ScheduleDto {
    private static final String DATE_FORMAT = "YYYY-MM-DD";

    private Long id;
    private String subject;
    private String contents;
    private String startDt;
    private String endDt;
    private Long groupId;

    public static ScheduleDto from(Schedule schedule){
        return ScheduleDto.builder()
                .id(schedule.getId())
                .subject(schedule.getSubject())
                .contents(schedule.getContents())
                .startDt(schedule.getStartDt())
                .endDt(schedule.getEndDt())
                .groupId(schedule.getGroup().getId())
                .build();
    }

    public static Schedule to(ScheduleDto dto){
        return Schedule.builder()
                .contents(dto.getContents())
                .subject(dto.getSubject())
                .startDt(dto.getStartDt())
                .endDt(dto.getEndDt())
                .build();
    }
}
