package com.example.springproject.repositories;

import com.example.springproject.models.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Slf4j
@Repository
public class ContactRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int saveContact(Contact contact){
        String sql = "INSERT INTO contact_msg(name, mobile_num, email, subject, message, status, created_at, created_by) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, contact.getName(), contact.getMobileNum(), contact.getEmail(), contact.getSubject(),
                contact.getMessage(), contact.getStatus(), Timestamp.valueOf(contact.getCreatedAt()), contact.getCreatedBy());
    }
}
