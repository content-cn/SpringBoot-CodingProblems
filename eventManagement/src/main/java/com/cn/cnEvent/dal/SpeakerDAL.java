package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Speaker;

import java.util.List;

public interface SpeakerDAL {

	Speaker getById(Long id);

	List<Speaker> getAllSpeakers();

	List<Speaker> getAllSpeakersByEventCount(Long eventCount);

	String save(Speaker speaker);
}
