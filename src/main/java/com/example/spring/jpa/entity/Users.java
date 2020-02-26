package com.example.spring.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Iman Khaeruddin
 * @see Serializable
 * @since 26/02/2020
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username is required")
    @Min(value = 5, message = "password min 5 character")
    private String username;

    @Column(name = "email")
    @NotNull(message = "email cannot be null")
    @NotBlank(message = "email is required")
    @Pattern(regexp = "[^@]+@[^\\.]+\\..+", message = "email invalid")
    private String email;

    @Column(name = "password")
    @NotNull(message = "password cannot be null")
    @NotBlank(message = "password is required")
    private String password;

    @Column(name = "first_name")
    @NotNull(message = "first name cannot be null")
    @NotBlank(message = "first name is required")
    private String first_name;

    @Column(name = "last_name")
    @NotNull(message = "last name cannot be null")
    @NotBlank(message = "last name is required")
    private String last_name;

    @Column(name = "phone")
    @NotNull(message = "phone number cannot be null")
    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^(?:[0-9] ?){6,14}[0-9]$", message = "phone number invalid")
    private String phone;
}
