package com.example.springproject.repositories;

import com.example.springproject.models.Contact;
import com.example.springproject.rowMappers.ContactRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

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

    public List<Contact> displayMessagesByStatus(String status){
        String sql = "SELECT * from contact_msg WHERE status = ?";
        return jdbcTemplate.query(sql, new ContactRowMapper(), status);
    }

    public int closeMessageById(int contactMessageId, String status, Timestamp updatedAt, String updatedBy){
        String sql = "UPDATE contact_msg SET status = ?, updated_at = ?, updated_by = ? WHERE contact_id = ?";
        return jdbcTemplate.update(sql, status, updatedAt, updatedBy, contactMessageId);
    }
}
