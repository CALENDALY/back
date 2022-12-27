package com.example.project.schedule.repository;

import com.example.project.schedule.repository.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select s from Schedule s " +
            "join fetch s.group " +
            "where s.group.id = :groupId " +
            "and s.startDt >= :startDt and s.endDt <= :endDt")
    List<Schedule> findAllScheduleInDate(@Param("groupId") Long groupId, @Param("startDt") String startDt, @Param("endDt")String endDt);
}
