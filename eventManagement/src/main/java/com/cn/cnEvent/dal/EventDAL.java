package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;

import java.util.List;

public interface EventDAL {

	Event getById(int id);

	void save(Event item);

	List<Event> getAllEvents();
}
