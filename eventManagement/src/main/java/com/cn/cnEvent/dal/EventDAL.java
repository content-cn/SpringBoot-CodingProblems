package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;

import java.util.List;

public interface EventDAL {

	Event getById(int id);

	void save(Event item);

	List<Event> getAll();

	void delete(int id);

	void update(Event updateEvent);

}
