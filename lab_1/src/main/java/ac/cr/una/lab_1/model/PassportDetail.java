/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab_1.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jecas
 */
@Entity
@Table(name = "passport_detail")
public class PassportDetail {

    public PassportDetail() {
    }

    public PassportDetail(int id, String passportno) {
        this.id = id;
        this.passportno = passportno;
    }

    public int getId() {
        return id;
    }

    public String getPassportno() {
        return passportno;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.passportno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PassportDetail other = (PassportDetail) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.passportno, other.passportno)) {
            return false;
        }
        return true;
    }
    
    
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @Column(name = "passportno")
    private String passportno;
}
