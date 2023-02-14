package com.cn.cnEvent.entity;

import java.time.LocalDateTime;

public class EventScheduleDetail {
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String location;

    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEvent(Object o) {
    }
}