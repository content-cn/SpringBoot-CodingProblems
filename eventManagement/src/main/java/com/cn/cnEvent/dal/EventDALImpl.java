package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDALImpl implements EventDAL {

	@Autowired
	EntityManager entityManager;

	@Override
	public Event getById(Long id) {
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
	public List<Event> getAllEventsByLocation(String location) {
		Session session = entityManager.unwrap(Session.class);
		List<Event> allEvents= session.createQuery(
				"SELECT e FROM Event e", Event.class).getResultList();

		List<Event> eventsByLocation = new ArrayList<>();
		for(Event event : allEvents)
		{
			if(event.getEventScheduleDetail().getLocation().equalsIgnoreCase(location))
			{
				eventsByLocation.add(event);
			}
		}
		return eventsByLocation;
	}

	@Override
	public EventScheduleDetail getEventScheduleDetailByEventId(Long id){
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		return event.getEventScheduleDetail();
	}

	@Override
	public List<Ticket> getAllTicketsOfEvent(Long id){
		Event event = getById(id);
		return event.getTickets();
	}

	@Override
	public List<Event> getAllEventsHavingTicketPriceGreaterThan(Long price){
		Session session = entityManager.unwrap(Session.class);
		List<Event> allEvents=getAllEvents();
		List<Event> eventsByPrice = new ArrayList<>();
		for(Event event : allEvents)
		{
			for(Ticket ticket : event.getTickets())
			{
				if(ticket.getPrice()>1000)
				{
					eventsByPrice.add(event);
					break;
				}
			}
		}
		return eventsByPrice;
	}

	@Override
	public String save(Event event) {
		Session session = entityManager.unwrap(Session.class);
		session.save(event);
		return "The event was saved successfully.";
	}

	@Override
	public String delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		session.delete(event);
		return "The event was deleted successfully";
	}

	@Override
	public String deleteEventScheduleDetail(Long id) {
		Session session = entityManager.unwrap(Session.class);
		EventScheduleDetail eventScheduleDetail = session.createQuery(
				"SELECT e FROM EventScheduleDetail e where e.event.id = :id", EventScheduleDetail.class).
				setParameter("id",id).getSingleResult();
		session.delete(session.get(EventScheduleDetail.class,eventScheduleDetail.getId()));
		return "The eventSchedule was deleted successfully";
	}

	@Override
	public void update(Event updateEvent) {
		Session session = entityManager.unwrap(Session.class);
		Event currentEvent = session.get(Event.class, updateEvent.getId());
		currentEvent.setName(updateEvent.getName());
		session.update(currentEvent);
		
	}
	
}
