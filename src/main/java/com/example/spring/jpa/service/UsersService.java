package com.example.spring.jpa.service;

import com.example.spring.jpa.entity.Users;

public interface UsersService {
    /**
     * @param users
     * @return {@link com.example.spring.jpa.entity.Users}
     */
    Users createUsers(Users users);

    /**
     * @return list of {@link com.example.spring.jpa.entity.Users}
     */
    Iterable<Users> getAllUsers();

    /**
     * @return {@link com.example.spring.jpa.entity.Users}
     */
    Users getByUserID(int id);

    /**
     * @param users
     * @return {@link com.example.spring.jpa.entity.Users}
     */
    Users editUsers(Users users);
}
