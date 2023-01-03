package com.example.project.schedule.repository.domain;

import com.example.project.common.BaseEntity;
import com.example.project.common.DateType;
import com.example.project.group.repository.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(style = DateType.TYPE)
    private String startDt;

    @DateTimeFormat(style = DateType.TYPE)
    private String endDt;

    @Column(nullable = false)
    private String subject;

    @Column(length = 200)
    private String contents;

    private String thumbNailUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    public void matchGroup(Group group){
        this.group = group;
    }
}
