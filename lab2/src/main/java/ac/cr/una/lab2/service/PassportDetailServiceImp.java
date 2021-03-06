/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.service;

import ac.cr.una.lab2.dao.PassportDetailDao;
import ac.cr.una.lab2.model.PassportDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jecas
 */
@Service
public class PassportDetailServiceImp implements PassportDetailService{

    @Transactional
    @Override
    public void add(PassportDetail passportDetail) {
        passportDetailDao.add(passportDetail);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PassportDetail> listPassportDetailts() {
        return passportDetailDao.listPassportDetails();
    }
    
    @Autowired
    private PassportDetailDao passportDetailDao;
}
