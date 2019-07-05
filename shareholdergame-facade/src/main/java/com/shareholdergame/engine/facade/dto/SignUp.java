package com.shareholdergame.engine.facade.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class SignUp {

    @NotBlank
    public String userName;

    @NotBlank
    public String email;

    @NotBlank @Length(min = 6)
    public String password;
}
