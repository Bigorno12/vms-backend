package com.pacdesign.service.impl;

import com.pacdesign.persistence.entity.Person;
import com.pacdesign.persistence.repository.PersonRepository;
import com.pacdesign.service.AuthService;
import com.pacdesign.service.dto.PersonDto;
import com.pacdesign.service.exception.UserAlreadyPresentException;
import com.pacdesign.service.mapper.PersonMapper;
import com.pacdesign.service.security.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

@Service
public class AuthServiceImpl implements AuthService {

    private final PersonRepository personRepository;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final PersonMapper personMapper;

    public AuthServiceImpl(PersonRepository personRepository, JWTUtil jwtUtil, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.personMapper = personMapper;
    }

    @Override
    public Map<String, Object> registerHandler(PersonDto personDto) {
        Person getPerson = personRepository.findPersonByUsername(personDto.getUsername())
                .map(person -> savePerson().apply(person)).orElseThrow(() -> {
                    throw new UserAlreadyPresentException(personDto.getUsername().concat(" already exists"));
                });

        String token = jwtUtil.generateToken(getPerson.getUsername());
        return Collections.singletonMap("jwt-token", token);
    }

    @Override
    public Map<String, Object> loginHandler(PersonDto personDto) {
        try {
            UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(personDto.getUsername(), personDto.getPassword());
            authenticationManager.authenticate(authInputToken);
            String token = jwtUtil.generateToken(personDto.getUsername());

            return Collections.singletonMap("jwt-token", token);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid Login Credentials");
        }
    }


    public Function<Person, Person> savePerson() {
        return person -> {
            String encodedPass = passwordEncoder.encode(person.getPassword());
            person.setPassword(encodedPass);
            return personRepository.save(person);
        };
    }


}
