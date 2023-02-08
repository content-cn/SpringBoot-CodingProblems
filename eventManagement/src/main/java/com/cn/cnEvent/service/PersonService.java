package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.PersonDAL;
import com.cn.cnEvent.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

	@Autowired
	PersonDAL personDAL;

	@Transactional
	public Person getPersonById(Long id) {
		return personDAL.getById(id);
	}

	@Transactional
	public List<Person> getAllPersons() {
		return personDAL.getAllPersons();
	}

	@Transactional
	public String savePerson(Person person) {
		return personDAL.save(person);
	}

	@Transactional
	public String delete(Long id) {
		return personDAL.delete(id);
	}

	@Transactional
	public void update(Person updatePerson) {
		personDAL.update(updatePerson);
	}

}
