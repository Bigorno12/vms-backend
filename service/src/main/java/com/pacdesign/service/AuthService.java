package com.pacdesign.service;

import com.pacdesign.service.dto.PersonDto;

import java.util.Map;

public interface AuthService {
    Map<String, Object> registerHandler(PersonDto personDto);

    Map<String, Object> loginHandler(PersonDto personDto);
}
