package com.example.project.schedule.service;

import com.example.project.group.repository.Group;
import com.example.project.group.repository.GroupRepository;
import com.example.project.schedule.dto.ScheduleDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
        group.setId(1l);
        Group groupEntity = repository.save(group);

        service.enrollSchedule(ScheduleDto.builder()
                .contents("id")
                .subject("subject")
                .startDt("2022-12-24")
                .endDt("2022-12-25")
                .build(), groupEntity);

        service.enrollSchedule(ScheduleDto.builder()
                .contents("id")
                .subject("subject")
                .startDt("2023-01-01")
                .endDt("2023-01-02")
                .build(), groupEntity);

        assertThat(service.getScheduleInDate(1L, "2022-12-20", "2022-12-31"))
                .hasSize(1);
    }

}