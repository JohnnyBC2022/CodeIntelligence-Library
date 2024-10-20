package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.Role;
import com.example.biblioteca.models.UserDto;
import com.example.biblioteca.models.UserEntity;
import com.example.biblioteca.repository.UserRepository;
import com.example.biblioteca.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public String getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Override
    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userRepository.findByUsername(authentication.getName()).orElse(null);
        return user;
    }

    @Override
    public void save(int id, UserDto userDto) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userDto, user);
        this.userRepository.save(user);
    }

    @Override
    public boolean isAdmin(UserEntity user) {
        return user.getRole() == Role.ADMIN;
    }
}
