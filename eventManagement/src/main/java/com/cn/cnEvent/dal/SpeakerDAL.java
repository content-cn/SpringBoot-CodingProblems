package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Speaker;

import java.util.List;

public interface SpeakerDAL {

	Speaker getById(Long id);

	List<Speaker> getAllSpeakers();

	String save(Speaker speaker);

	String delete(Long id);

	void update(Speaker updateSpeaker);
}
