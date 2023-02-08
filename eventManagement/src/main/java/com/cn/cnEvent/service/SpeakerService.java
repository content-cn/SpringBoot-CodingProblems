package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpeakerService {

	@Autowired
	SpeakerDAL speakerDAL;

	@Transactional
	public Speaker getSpeakerById(Long id) {
		return speakerDAL.getById(id);
	}

	@Transactional
	public List<Speaker> getAllSpeakers() {
		return speakerDAL.getAllSpeakers();
	}

	@Transactional
	public String saveSpeaker(Speaker speaker) {
		return speakerDAL.save(speaker);
	}

	@Transactional
	public String delete(Long id) {
		return speakerDAL.delete(id);
	}

	@Transactional
	public void update(Speaker updateSpeaker) {
		speakerDAL.update(updateSpeaker);
	}
}
