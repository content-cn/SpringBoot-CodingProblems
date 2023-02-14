package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class SpeakerController {

    public Speaker getSpeakerById(@PathVariable Long id)
    {
    }

    public List<Speaker> getAllSpeakers()
    {
    }

    public List<Speaker> getAllSpeakersByEventCountAndExperience(@PathVariable Long eventCount, @PathVariable Long experience)
    {
    }

    public void addSpeakerToEvent(@PathVariable("eventId") Long eventId, @PathVariable("speakerId") Long speakerId) {

    }

    public  String saveSpeaker(@RequestBody Speaker speaker) {
    }
}
