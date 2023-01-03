package com.example.project.schedule.controller;

public class RequestSchd {
    record GetDate(
            Long groupId,
            String startDate,
            String endDate
    ) {

    }

    record EnrollSchd(
            String subject,
            String contents,
            String startDt,
            String endDt,
            Long groupId
    ) {

    }
}
