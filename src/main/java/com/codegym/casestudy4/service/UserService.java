package com.codegym.casestudy4.service;

import com.codegym.casestudy4.dto.UserDto;
import com.codegym.casestudy4.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    User findUserByUsername(String username);
    UserDto findUserById(long id);

    boolean isPasswordCorrect(String rawPassword, String encodedPassword);

//    List<UserDto> findAllUser();
}
