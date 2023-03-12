package com.pacdesign.service.impl;

import com.pacdesign.persistence.repository.PersonRepository;
import com.pacdesign.service.PersonService;
import com.pacdesign.service.dto.PersonDto;
import com.pacdesign.service.exception.UserAlreadyPresentException;
import com.pacdesign.service.mapper.PersonMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

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
        personRepository.findPersonByUsername(personDto.getUsername())
                .ifPresentOrElse(person -> {
                    throw new UserAlreadyPresentException(personDto.getUsername().concat(" already exists"));
                }, () -> personRepository.save(personMapper.mapToEntity(personDto)));

    }

    @Override
    public UserDetails loadPersonByUsername(String username) {
        return personRepository.findPersonByUsername(username)
                .map(person -> new User(person.getUsername(), person.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority(person.getRoles().name()))))
                .orElseThrow();
    }
}
