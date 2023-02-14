package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class SpeakerController {

    /*
     1. Call the required service method
     2. Add proper annotations for Get Mapping and fetch the
         id from URL using PathVariable.
    */
    public Speaker getSpeakerById(@PathVariable Long id)
    {
    }

    /*
     1. Call the required service method
     2. Add proper annotations for Get Mapping.
    */
    public List<Speaker> getAllSpeakers()
    {
    }

    /*
     1. Call the required service method
     2. Add proper annotations for Get Mapping and fetch the
         event count and experience from URL using PathVariable.
    */
    public List<Speaker> getAllSpeakersByEventCountAndExperience(@PathVariable Long eventCount, @PathVariable Long experience)
    {
    }

    /*
     1. Call the required service method
     2. Add proper annotations for Post Mapping and fetch the
         eventId and speakerId from URL using PathVariable.
    */
    public void addSpeakerToEvent(@PathVariable("eventId") Long eventId, @PathVariable("speakerId") Long speakerId) {

    }

    /*
     1. Call the required service method
     2. Add proper annotations for Post Mapping and fetch the
         speaker from the Request Body.
    */
    public  String saveSpeaker(@RequestBody Speaker speaker) {
    }
}
