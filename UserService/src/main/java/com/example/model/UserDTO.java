package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String login;
    private String password;
    private String orders;
}
