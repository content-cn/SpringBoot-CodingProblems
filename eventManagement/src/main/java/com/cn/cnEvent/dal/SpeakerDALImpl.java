package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Speaker;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SpeakerDALImpl implements SpeakerDAL {

	@Autowired
	EntityManager entityManager;
	
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
