package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;

public interface EventDAL {

	Event getById(int id);

	void save(Event item);

	void delete(int id);

	void update(Event updateEvent);

}
