package com.example.springproject.services;

import com.example.springproject.models.Contact;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ContactService {

    private static final Logger logger = Logger.getLogger(ContactService.class.getName());
    public boolean saveMessageInDB(Contact contact){
        boolean isSaved = true;
        logger.info("Messages saved in DB");
        return true;
    }
}
