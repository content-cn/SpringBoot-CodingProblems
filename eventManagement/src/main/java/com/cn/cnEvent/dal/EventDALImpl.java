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

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		session.delete(event);
		
	}

	@Override
	public void update(Event updateEvent) {
		Session session = entityManager.unwrap(Session.class);
		Event currentEvent = session.get(Event.class, updateEvent.getId());
		currentEvent.setName(updateEvent.getName());
		session.update(currentEvent);
		
	}
	
}
