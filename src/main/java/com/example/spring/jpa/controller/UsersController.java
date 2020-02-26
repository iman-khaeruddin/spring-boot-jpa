package com.example.spring.jpa.controller;

import com.example.spring.jpa.entity.Users;
import com.example.spring.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Iman Khaeruddin
 * @since 26/02/2020
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * Save user data.
     *
     * @param users
     * @return {@link Users}
     */
    @PostMapping(value = "/create")
    ResponseEntity<Users> insertUser(@Valid @RequestBody Users users) {

        return new ResponseEntity<>(usersService.createUsers(users), HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.put("error_message", errorMessage);
        });
        return errors;
    }
}
