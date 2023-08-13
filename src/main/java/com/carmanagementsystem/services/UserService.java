package com.carmanagementsystem.services;

import com.carmanagementsystem.dtos.PageableResponse;
import com.carmanagementsystem.dtos.UserDto;
import com.carmanagementsystem.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,String userId);
    UserDto getUserById(String userId);
    UserDto getUserByEmail(String email);
    void deleteUser(String userId) ;
    PageableResponse<UserDto> getAllUsers(int pageNumber, int pageSize, String sortBy, String sortDir);
    List<UserDto> searchUser(String keyword);
    Optional<User> getUserByEmailForGoogleAuth(String email);
}
