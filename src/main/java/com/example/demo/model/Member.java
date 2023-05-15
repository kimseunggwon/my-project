package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class Member {

    private Long id;
    private String name;
    private Integer age;
    private Integer passWord;
    private String nickName;
    private LocalDateTime createdAt;

    private Integer quantity;

}
