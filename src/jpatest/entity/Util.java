/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpatest.entity;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Util implements Serializable {
    
    public enum UtilType {
        Normal,
        MODERATEUR,
        ADMIN
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //ajouter pour referent id login mdp
    @Column(unique = true,length = 32,nullable = false)
            private String mdp;
    @Column(unique = true,length = 32,nullable = false)
    private String login;
    
    @Temporal(TemporalType.TIME)
    private Date datecreation;
    
    @Enumerated(EnumType.STRING)
    private UtilType utiltype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Util)) {
            return false;
        }
        Util other = (Util) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpatest.entity.Util[ id=" + id + " ]";
    }
    
}
