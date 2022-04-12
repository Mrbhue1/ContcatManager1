package com.NewProject.Repo;

import com.NewProject.Model.Contact;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContactRepo extends CrudRepository<Contact,Integer> {

}
