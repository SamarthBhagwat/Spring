package com.example.springproject.services;

import com.example.springproject.models.Contact;
import com.example.springproject.utils.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springproject.repositories.ContactRepository;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    public boolean saveMessage(Contact contact){
        boolean isSaved = false;
        contact.setStatus(ApplicationConstants.DEFAULT_CONTACT_STATUS);
        contact.setCreatedBy(ApplicationConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContact(contact);
        if(result > 0)
            isSaved = true;
        return isSaved;
    }

    public List<Contact> displayMessagesByStatus(){
        return contactRepository.displayMessagesByStatus(ApplicationConstants.DEFAULT_CONTACT_STATUS);
    }
}
