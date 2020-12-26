package com.tbetcha.app.ws.service.impl;

import com.tbetcha.app.ws.UserRepository;
import com.tbetcha.app.ws.io.entity.UserEntity;
import com.tbetcha.app.ws.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tbetcha.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetails =  userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);
        return returnValue;
    }
}