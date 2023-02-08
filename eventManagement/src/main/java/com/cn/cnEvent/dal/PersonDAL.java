package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Person;

import java.util.List;

public interface PersonDAL {

	Person getById(Long id);

	List<Person> getAllPersons();

	String save(Person item);

	String delete(Long id);

	void update(Person updatePerson);
}
