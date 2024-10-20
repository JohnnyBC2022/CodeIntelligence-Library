package com.example.biblioteca.services;

import com.example.biblioteca.models.UserDto;
import com.example.biblioteca.models.UserEntity;

public interface UserService {
    String getUserEmail();

    UserEntity getCurrentUser();

    void save(int id, UserDto userDto);

    boolean isAdmin();

}
