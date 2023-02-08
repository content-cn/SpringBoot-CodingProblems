package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    SpeakerService speakerService;

    @GetMapping("/id/{id}")
    public Speaker getSpeakerById(@PathVariable Long id)
    {
        return speakerService.getSpeakerById(id);
    }

    @GetMapping("/allSpeakers")
    public List<Speaker> getAllSpeakers()
    {
        return speakerService.getAllSpeakers();
    }

    @PostMapping("/save")
    public  String saveSpeaker(@RequestBody Speaker speaker)
    {
        return speakerService.saveSpeaker(speaker);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteSpeaker(@PathVariable Long id)
    {
        return speakerService.delete(id);
    }

    @PutMapping("/update")
    public void updateSpeaker(@RequestBody Speaker updateSpeaker)
    {
        speakerService.update(updateSpeaker);
    }

}
