package com.example.springproject.models;

import lombok.Data;

@Data
public class Contact {

    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
}
