package com.cn.cnEvent.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

	@OneToOne(mappedBy = "event")
	private EventScheduleDetail eventScheduleDetail;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "event_speaker", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "speaker_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "event_id", "speaker_id" }) })

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

	public EventScheduleDetail getEventScheduleDetail() {
		return eventScheduleDetail;
	}

	public void setEventScheduleDetail(EventScheduleDetail eventScheduleDetail) {
		this.eventScheduleDetail = eventScheduleDetail;
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
