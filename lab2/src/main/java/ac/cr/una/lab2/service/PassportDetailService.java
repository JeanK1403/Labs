/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.service;

import ac.cr.una.lab2.model.PassportDetail;
import java.util.List;

/**
 *
 * @author jecas
 */
public interface PassportDetailService {
    void add(PassportDetail passportDetail);
    List<PassportDetail> listPassportDetailts();
}
