package com.cn.cnEvent.dal;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Event;

import java.util.List;

@Repository
public class EventDALImpl implements EventDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Event getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		Session session = entityManager.unwrap(Session.class);
		List<Event> allEvents= session.createQuery(
				"SELECT e FROM Event e", Event.class).getResultList();
		return allEvents;
	}

	@Override
	public void save(Event event) {
		Session session = entityManager.unwrap(Session.class);
		session.save(event);
	}
}
