package com.tbetcha.app.ws.ui.controller;

import com.tbetcha.app.ws.ui.model.request.UserDetailsRequestModel;
import com.tbetcha.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tbetcha.app.ws.service.UserService;
import com.tbetcha.app.ws.shared.dto.UserDto;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping(path="/{id}")
    public UserRest getUser(@PathVariable String id){
        UserRest returnValue = new UserRest();
       UserDto userDto = userService.getUserByUserId(id);
       BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;

    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();

        UserDto  userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }

    @PutMapping
    public String updateUser(){
        return "Update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete user was called";
    }
}
