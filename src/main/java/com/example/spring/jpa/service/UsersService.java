package com.example.spring.jpa.service;

import com.example.spring.jpa.entity.Users;

public interface UsersService {
    /**
     * @param users
     * @return {@link com.example.spring.jpa.entity.Users}
     */
    Users createUsers(Users users);
}
