package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
public class PersonController {

    public Person getPersonById(@PathVariable Long id)
    {
    }

    public List<Person> getAllPersons()
    {
    }
}
