package com.proit.assignment.data.service;

import com.proit.assignment.data.entity.Company;
import com.proit.assignment.data.entity.Contact;
import com.proit.assignment.data.entity.Status;
import com.proit.assignment.data.repository.CompanyRepository;
import com.proit.assignment.data.repository.ContactRepository;
import com.proit.assignment.data.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmService {
    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    public CrmService(ContactRepository contactRepository,
                      CompanyRepository companyRepository,
                      StatusRepository statusRepository) {
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }

    public List<Contact> findAllContacts(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return contactRepository.findAll();
        }else {
            return contactRepository.search(filterText);
        }
    }

    public long countAllContacts() {
        return contactRepository.count();
    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    public void saveContact(Contact contact) {
        if(contact == null) {
            System.err.println("Contact is null.");
            return;
        }
        contactRepository.save(contact);
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Status> findAllStatuses() {
        return statusRepository.findAll();
    }
}
