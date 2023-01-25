package com.cn.cnEvent.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
	private EventScheduleDetails eventScheduleDetails;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "event_speaker",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "speaker_id"))
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

