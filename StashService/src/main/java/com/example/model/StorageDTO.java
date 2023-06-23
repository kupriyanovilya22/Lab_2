package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorageDTO {

    private Long id;
    private String name;
    private int quantity;
    private String category;
    private String description;
}
