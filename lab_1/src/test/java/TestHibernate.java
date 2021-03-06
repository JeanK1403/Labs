/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ac.cr.una.lab_1.HibernateUtil;
import ac.cr.una.lab_1.model.PassportDetail;
import ac.cr.una.lab_1.model.Person;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author jecas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHibernate {
    
    private static Session session;
    
    public TestHibernate() {
    }
    
    @Before
    public void setUp() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    @AfterClass
    public static void tearDown() {
        session.close();
        HibernateUtil.shutdown();
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test1Save() {
         //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
         //Session session = sessionFactory.openSession();
         session.beginTransaction();
         
         PassportDetail passportDetail = new PassportDetail();
         passportDetail.setPassportno("pass_1");
         
         session.save(passportDetail);
         System.out.println("Passport saved, id: " + passportDetail.getId());
         
         Person person = new Person();
         person.setName("Person_2");
         person.setPassport_detail_id(passportDetail);
         
         session.save(person);
         System.out.println("Person saved, id: " + person.getId());
         
         session.getTransaction().commit();
         //session.close();
         //HibernateUtil.shutdown();
    }
     
    @Test
    public void test2List(){
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        //Get:
//        Person person = (Person) session.get(Person.class, new Integer(4));
        
        //Get all      
//        List<Person> list = session.createCriteria(Person.class).list();
        List<Person> list = session.createQuery("from Person").list();
        
        for(Person person: list){
            System.out.println("Name: " + person.getName());
            System.out.println("Passport: " + person.getPassport_detail_id().getPassportno());
        }
        
        session.getTransaction().commit();
//        session.close();
//        HibernateUtil.shutdown();
    }
}
