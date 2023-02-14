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

	//Complete the method body to get a Speaker by its id. Also implement Exception Handling.
	public Speaker getSpeakerById(Long id) {
	}

	//Complete the method body to get All Speakers. Also implement Exception Handling.
	public List<Speaker> getAllSpeakers() {
	}

	//Complete the method body get All Speakers with values of eventCount and experience more than the given values.. Also implement Exception Handling.
	public List<Speaker> getAllSpeakersByEventCountAndExperience(Long eventCount, Long experience) {
	}

	//Complete the method body add a link between a eventId and speakerId in their combined table. Also implement Exception Handling.
	public void addSpeakerToEvent(Long eventId, Long speakerId) {
	}

	//Complete the method body to save an existing Speaker. Also implement Exception Handling.
	public String saveSpeaker(Speaker newSpeaker) {
	}
}
