/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.dao;

import ac.cr.una.lab2.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author jecas
 */
@Repository
public class PersonDaoImp implements PersonDao{

    @Override
    public void add(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public List<Person> listPerson() {
        @SuppressWarnings("unchecked")
        TypedQuery<Person> query = sessionFactory.getCurrentSession().createQuery("from Person");
        return query.getResultList();
    }

    @Autowired
    private SessionFactory sessionFactory;
        
}
