package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventScheduleDetailService {

	@Autowired
	EventScheduleDetailDAL eventScheduleDetailDAL;

	@Transactional
	public EventScheduleDetail getEventScheduleDetailById(Long id) {
		return eventScheduleDetailDAL.getById(id);
	}

	@Transactional
	public List<EventScheduleDetail> getAllEventScheduleDetails() {
		return eventScheduleDetailDAL.getAllEventScheduleDetails();
	}

	@Transactional
	public String saveEventScheduleDetail(EventScheduleDetail eventScheduleDetail) {
		return eventScheduleDetailDAL.save(eventScheduleDetail);
	}

	@Transactional
	public String delete(Long id) {
		return eventScheduleDetailDAL.delete(id);
	}

	@Transactional
	public void update(EventScheduleDetail updateEventScheduleDetail) {
		eventScheduleDetailDAL.update(updateEventScheduleDetail);
	}

}
