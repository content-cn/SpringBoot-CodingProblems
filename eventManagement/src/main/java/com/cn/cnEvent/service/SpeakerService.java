package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpeakerService {

	@Autowired
	SpeakerDAL speakerDAL;

	public Speaker getSpeakerById(Long id) {
	}

	public List<Speaker> getAllSpeakers() {
	}

	public List<Speaker> getAllSpeakersByEventCountAndExperience(Long eventCount, Long experience) {
	}

	public void addSpeakerToEvent(Long eventId, Long speakerId) {
	}

	public String saveSpeaker(Speaker newSpeaker) {
	}
}
