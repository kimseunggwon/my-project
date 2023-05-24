package com.example.demo.model;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Member {

    private Long id;
    private String name;
    private Integer age;
    private String password;
    private LocalDateTime createdAt;
    private Integer quantity;

    // new
    private String loginId;

}
