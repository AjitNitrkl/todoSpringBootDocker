package com.example.todoapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
public class User {

    private String fname;
    private String lname;
    private String email;
    private String mobile;

}