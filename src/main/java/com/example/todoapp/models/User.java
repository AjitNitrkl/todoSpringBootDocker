package com.example.todoapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class User {

    private String fName;
    private String lName;
    private String email;
    private String mobile;

}