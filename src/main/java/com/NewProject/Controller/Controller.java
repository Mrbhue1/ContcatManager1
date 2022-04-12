package com.NewProject.Controller;

import com.NewProject.Model.Contact;
import com.NewProject.Repo.ContactRepo;
import com.NewProject.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {


    @Autowired
    public ContactRepo contactRepo;
    @Autowired
    public ContactService contactService;

//    @GetMapping("/")
//    public String viewHomePage() {
//        return "index";
//    }
    @PostMapping("/add")
    public String add(@ModelAttribute Contact contact, Model m) {
        System.out.println("contact to save = "+ contact.getName());
        if (contact.getId() == 0) {
            contactRepo.save(contact);
        } else {
            update(contact);
        }

        m.addAttribute("contact", new Contact());
        List<Contact> contacts = (List<Contact>) contactRepo.findAll();
//Collections.sort(contacts);
        System.out.println(" contacts = "+ contacts.size());
        m.addAttribute("contacts", contacts);
        return "contact";
    }

    @GetMapping("/add")
    public String findAllContacts(Model model) {
        System.out.println("findAllContacts in db");
        model.addAttribute("contact", new Contact());
        List<Contact> contacts = (List<Contact>) contactRepo.findAll();
        System.out.println("contacts = "+ contacts.size());
        model.addAttribute("contacts", contacts);
        return "contacts";
    }


//    public void update(Contact c) {
//        System.out.println("Update called with ID =" + c.getId());
//        contactRepo.save(c);
//    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        System.out.println("Delete called with ID = "+ id);
        Optional<Contact> c = contactRepo.findById(id);
        contactRepo.delete(c);
        model.addAttribute("contact", new Contact());
        List<Contact> contacts = (List<Contact>) contactRepo.findAll();
        System.out.println("contacts = "+ contacts.size());
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    //new Code implementing
    @GetMapping("/delete")
    public String deleteContact(@PathVariable (value = "id") long id) {
        // call delete employee method
        this.contactService.deleteContactById(id);
        return "redirect:/";

    }
    @PostMapping("/add")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        // save employee to database
        contactService.saveContacts(contact);
        return "redirect:/";
    }
    @PutMapping("/update")
    private Contact update(@ModelAttribute(value = "id") Contact contact) {
        contactService.updateContact(contact);
        return contact;
    }
}

