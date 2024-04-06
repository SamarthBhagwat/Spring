package com.example.springproject.models;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Contact extends BaseEntity{

    private int contactId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be greater than 3 characters")
    private String name;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must contain only 10 digits")
    private String mobileNum;

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email must be in valid email format")
    private String email;

    @NotBlank(message = "Subject must not be blank")
    @Size(min = 5, message = "Minimum 5 characters required in subject")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min = 10, message = "Minimum 10 character required in message")
    private String message;

    private String status;
}
