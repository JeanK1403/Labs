/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.service;

import ac.cr.una.lab2.dao.PersonDao;
import ac.cr.una.lab2.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jecas
 */
@Service
public class PersonServiceImp implements PersonService{

    @Transactional
    @Override
    public void add(Person person) {
        personDao.add(person);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> listPerson() {
        return personDao.listPerson();
    }
    
    @Autowired
    private PersonDao personDao;
}
