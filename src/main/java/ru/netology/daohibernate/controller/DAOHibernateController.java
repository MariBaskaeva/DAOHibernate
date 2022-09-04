package ru.netology.daohibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.netology.daohibernate.model.Persons;
import ru.netology.daohibernate.repository.DAOHibernateRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DAOHibernateController {
    @Autowired
    private DAOHibernateRepository repository;

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam String city){
        return repository.getPersonsByCity(city);
    }
}
