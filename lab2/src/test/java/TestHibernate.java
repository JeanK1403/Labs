/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ac.cr.una.lab2.config.AppConfig;
import ac.cr.una.lab2.model.PassportDetail;
import ac.cr.una.lab2.model.Person;
import ac.cr.una.lab2.service.PassportDetailService;
import ac.cr.una.lab2.service.PersonService;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author jecas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHibernate {
    
    public TestHibernate() {
    }
    
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        passportDetailService = context.getBean(PassportDetailService.class);
        personService = context.getBean(PersonService.class);
    }
    
    @After
    public void tearDown() {
        context.close();
    }

//    @Test
//    public void test1Save() {
//        PassportDetail passportDetail = new PassportDetail(0, "pass1");
//        passportDetailService.add(passportDetail);
//        personService.add(new Person(0, "Andrea", passportDetail));
//        passportDetail.setId(1);
//        passportDetail.setPassportno("pass2");
//        passportDetailService.add(passportDetail);
//        personService.add(new Person(1, "Daniela", passportDetail));
//        passportDetail.setId(2);
//        passportDetail.setPassportno("pass3");
//        passportDetailService.add(passportDetail);
//        personService.add(new Person(2, "Jose", passportDetail));
//    }
    
    @Test
    public void test2List() {
        List<Person> listPerson = personService.listPerson();
        for(Person person : listPerson){
            System.out.println(person.toString());
            
            assertNotNull(person.getId());
        }
    }
    
    private static AnnotationConfigApplicationContext context = null;
    private static PassportDetailService passportDetailService = null;
    private static PersonService personService = null;
}
