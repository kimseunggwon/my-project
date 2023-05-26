package com.example.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginForm {

    @NotNull(message = "아이디 입력하세요")
    private String loginId;

    @NotNull(message = "비밀번호 입력하세요")
    private String password;
}
