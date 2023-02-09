package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpeakerDALImpl implements SpeakerDAL {

	@Autowired
	EntityManager entityManager;

	@Autowired
	SpeakerService speakerService;
	
	@Override
	public Speaker getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Speaker speaker = session.get(Speaker.class, id);
		return speaker;
	}

	@Override
	public List<Speaker> getAllSpeakers() {
		Session session = entityManager.unwrap(Session.class);
		List<Speaker> allSpeakers= session.createQuery(
				"SELECT e FROM Speaker e", Speaker.class).getResultList();
		return allSpeakers;
	}

	@Override
	public List<Speaker> getAllSpeakersByEventCount(Long eventCount){

		List<Speaker> allSpeakers=speakerService.getAllSpeakers();
		List<Speaker> allSpeakersByEventCount=new ArrayList<>();
		for(Speaker speaker: allSpeakers)
		{
			if(speaker.getEvents().size()>=eventCount && speaker.getExperience()>5)
			{
				allSpeakersByEventCount.add(speaker);
			}
		}
		return allSpeakersByEventCount;
	}

	@Override
	public String save(Speaker speaker) {
		Session session = entityManager.unwrap(Session.class);
		session.save(speaker);
		return "The speaker was saved successfully.";
	}

	@Override
	public String delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Speaker speaker = session.get(Speaker.class, id);
		session.delete(speaker);
		return "The speaker was deleted successfully";
	}

	@Override
	public void update(Speaker updateSpeaker) {
		Session session = entityManager.unwrap(Session.class);
		Speaker currentSpeaker = session.get(Speaker.class, updateSpeaker.getId());
		currentSpeaker.setName(updateSpeaker.getName());
		session.update(currentSpeaker);
	}
}
