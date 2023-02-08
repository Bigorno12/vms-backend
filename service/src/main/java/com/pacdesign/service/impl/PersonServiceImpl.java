package com.pacdesign.service.impl;

import com.pacdesign.persistence.repository.UserRepository;
import com.pacdesign.service.UserService;
import com.pacdesign.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public PersonServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
}
