package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private Long id;
    private String name;
    private String titles;
    private int quantity;
}
