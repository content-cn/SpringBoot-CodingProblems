package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class EventScheduleDetailController {


    public EventScheduleDetail getEventScheduleDetailById(@PathVariable Long id)
    {
    }

    public List<EventScheduleDetail> getAllEventScheduleDetails()
    {
    }

    public  String saveEventScheduleDetail(@RequestBody EventScheduleDetail event)
    {
    }
}
