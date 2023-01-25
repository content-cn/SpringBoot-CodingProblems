package com.cn.cnEvent.entity;

import java.util.List;

public class Event {

	private Long id;

	private String name;

	private String description;

	private EventScheduleDetails eventScheduleDetails;

	private List<Ticket> tickets;

	private List<Speaker> speakers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EventScheduleDetails getEventScheduleDetails() {
		return eventScheduleDetails;
	}

	public void setEventScheduleDetails(EventScheduleDetails eventScheduleDetails) {
		this.eventScheduleDetails = eventScheduleDetails;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
}

