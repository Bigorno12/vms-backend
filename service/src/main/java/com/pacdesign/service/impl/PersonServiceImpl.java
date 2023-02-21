package com.pacdesign.service.impl;

import com.pacdesign.persistence.repository.PersonRepository;
import com.pacdesign.service.PersonService;
import com.pacdesign.service.dto.PersonDto;
import com.pacdesign.service.mapper.PersonMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public void savePerson(PersonDto personDto) {
        personRepository.save(personMapper.mapToEntity(personDto));
    }
}
