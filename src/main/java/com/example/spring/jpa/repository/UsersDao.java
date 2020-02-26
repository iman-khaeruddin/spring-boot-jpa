package com.example.spring.jpa.repository;

import com.example.spring.jpa.entity.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Iman Khaeruddin
 * @since 26/02/2020
 */
public interface UsersDao extends CrudRepository<Users, Integer> {
}
