package com.example.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginForm {


    @NotNull
    private String loginId;

    @NotNull
    private String password;
}
