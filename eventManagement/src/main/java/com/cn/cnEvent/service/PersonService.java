package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.PersonDAL;
import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

	public Person getPersonById(Long id) {
	}

	public List<Person> getAllPersons() {
	}

}
