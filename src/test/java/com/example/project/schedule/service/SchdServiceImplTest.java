package com.example.project.schedule.service;

import com.example.project.group.repository.Group;
import com.example.project.group.repository.GroupRepository;
import com.example.project.schedule.dto.ScheduleDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SchdServiceImplTest {

    @Autowired
    SchdService service;

    @Autowired
    GroupRepository repository;

    @Test
    void test_find_by_period_date(){
        Group group = new Group();
        group.setName("group1");
        Group groupEntity = repository.save(group);

        service.enrollSchedule(ScheduleDto.builder()
                .contents("id")
                .subject("subject")
                .startDt("2022-12-24")
                .endDt("2022-12-25")
                .build(), groupEntity.getId());

        service.enrollSchedule(ScheduleDto.builder()
                .contents("id")
                .subject("subject")
                .startDt("2023-01-01")
                .endDt("2023-01-02")
                .build(), groupEntity.getId());

        assertThat(service.getScheduleInDate(4L, "2022-12-20", "2022-12-31"))
                .hasSize(1);
    }

}