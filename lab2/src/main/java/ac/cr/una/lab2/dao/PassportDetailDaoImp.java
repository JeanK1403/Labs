/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.dao;

import ac.cr.una.lab2.model.PassportDetail;
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
public class PassportDetailDaoImp implements PassportDetailDao{
    
    @Override
    public void add(PassportDetail passportDetail) {
        sessionFactory.getCurrentSession().save(passportDetail);
    }

    @Override
    public List<PassportDetail> listPassportDetails() {
        @SuppressWarnings("unchecked")
        TypedQuery<PassportDetail> query = sessionFactory.getCurrentSession().createQuery("from passport_detailt");
        return query.getResultList();
    }
    
    @Autowired
    private SessionFactory sessionFactory;
}
