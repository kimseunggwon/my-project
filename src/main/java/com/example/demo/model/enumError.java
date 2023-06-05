package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum enumError {

    SUCCESS,
    ALREADY_LOGGED_IN,
    INVALID_CREDENTIALS,
    ERROR

}
