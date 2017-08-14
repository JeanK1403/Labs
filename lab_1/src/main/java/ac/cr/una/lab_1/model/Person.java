/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab_1.model;

import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author jecas
 */
@Entity
@Table(name = "person")
public class Person {

    public Person() {
    }

    public Person(int id, String name, PassportDetail passport_detail_id) {
        this.id = id;
        this.name = name;
        this.passport_detail_id = passport_detail_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PassportDetail getPassport_detail_id() {
        return passport_detail_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport_detail_id(PassportDetail passport_detail_id) {
        this.passport_detail_id = passport_detail_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.passport_detail_id);
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
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.passport_detail_id, other.passport_detail_id)) {
            return false;
        }
        return true;
    }
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_detail_id")
    private PassportDetail passport_detail_id;
}
