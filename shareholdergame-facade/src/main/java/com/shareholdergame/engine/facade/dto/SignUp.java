package com.shareholdergame.engine.facade.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUp {

    @NotBlank
    public String userName;

    @NotBlank
    public String email;

    @NotBlank @Size(min = 6)
    public String password;
}
