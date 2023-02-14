package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Person;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
public class PersonController {

    /*
     1. Call the required service method
     2. Add proper annotations for Get Mapping and fetch the
         id from URL using PathVariable.
    */
    public Person getPersonById(@PathVariable Long id)
    {
    }

    /*
     1. Call the required service method
     2. Add proper annotations for Delete Mapping.
    */
    public List<Person> getAllPersons()
    {
    }
}
