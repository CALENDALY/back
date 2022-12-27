package com.example.project.schedule.repository.domain;

import com.example.project.common.BaseEntity;
import com.example.project.common.DateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(style = DateType.TYPE)
    private LocalDateTime startDt;

    @DateTimeFormat(style = DateType.TYPE)
    private LocalDateTime endDt;

    @Column(nullable = false)
    private String subject;

    @Column(length = 200)
    private String contents;

    private String thumbNailUrl;
}
