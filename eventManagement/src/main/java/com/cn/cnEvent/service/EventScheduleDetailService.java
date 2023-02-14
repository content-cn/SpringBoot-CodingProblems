package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public class EventScheduleDetailService {

	public EventScheduleDetail getEventScheduleDetailById(Long id) {
	}

	public List<EventScheduleDetail> getAllEventScheduleDetails() {
	}

	public String saveEventScheduleDetail(EventScheduleDetail newEventScheduleDetail) {
	}
}
