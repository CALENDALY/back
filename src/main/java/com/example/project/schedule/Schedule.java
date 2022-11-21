package com.example.project.schedule;

import com.example.project.common.BaseEntity;
import com.example.project.common.DateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

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

}
