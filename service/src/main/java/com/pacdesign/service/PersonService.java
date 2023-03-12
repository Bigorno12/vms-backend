package com.pacdesign.service;

import com.pacdesign.service.dto.PersonDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface PersonService {

    void savePerson(PersonDto personDto);

    UserDetails loadPersonByUsername(String username);
}
