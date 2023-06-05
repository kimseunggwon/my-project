package com.example.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginForm {


    private String loginId;


    private String password;
}
