package com.NewProject.Service;

import com.NewProject.Model.Contact;
import com.NewProject.Repo.ContactRepo;

public interface ContactService extends ContactRepo {


    void deleteContactById(long id);

    void saveContacts(Contact contact);

    void updateContact(Contact contact);
}
