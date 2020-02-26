package com.example.spring.jpa.service.impl;

import com.example.spring.jpa.entity.Users;
import com.example.spring.jpa.repository.UsersDao;
import com.example.spring.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Iman Khaeruddin
 * @since 26/02/2020
 * @see com.example.spring.jpa.service.UsersService
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    @Transactional
    public Users createUsers(Users users) {

        return usersDao.save(users);

    }
}
