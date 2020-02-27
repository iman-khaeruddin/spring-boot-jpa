package com.example.spring.jpa.service.impl;

import com.example.spring.jpa.entity.Users;
import com.example.spring.jpa.repository.UsersDao;
import com.example.spring.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    @Override
    public Iterable<Users> getAllUsers() {
        return usersDao.findAll();
    }

    @Override
    public Users getByUserID(int id) {

        Users usr = new Users();

        Optional<Users> users = usersDao.findById(id);

        if (users.isPresent())
            usr = users.get();

        return usr;
    }

    @Override
    @Transactional
    public Users editUsers(Users users) {

        Users userTemp = new Users();

        Optional<Users> usr = usersDao.findById(users.getId());

        //if entity already exist will update data and returned, if entity empty will return empty object
        if (usr.isPresent()) {
            userTemp = usr.get();

            userTemp.setEmail(users.getEmail());
            userTemp.setFirst_name(users.getFirst_name());
            userTemp.setLast_name(users.getLast_name());
            userTemp.setPhone(users.getPhone());

            usersDao.save(userTemp);
        }

        return userTemp;
    }
}
