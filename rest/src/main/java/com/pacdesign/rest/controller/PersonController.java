package com.pacdesign.rest.controller;

import com.pacdesign.service.PersonService;
import com.pacdesign.service.dto.PersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/save")
    public void save(@RequestBody PersonDto personDto) {
        personService.savePerson(personDto);
    }
}
