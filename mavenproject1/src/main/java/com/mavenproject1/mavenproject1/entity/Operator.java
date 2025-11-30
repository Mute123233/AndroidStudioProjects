/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mavenproject1.mavenproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author 8277
 */
@Entity
@Table(name = "Operator")
@NamedQueries({
    @NamedQuery(name = "Operator.findAll", query = "SELECT o FROM Operator o"),
    @NamedQuery(name = "Operator.findByIdOperator", query = "SELECT o FROM Operator o WHERE o.idOperator = :idOperator")})
public class Operator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOperator")
    private Integer idOperator;
    @JsonIgnore       @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne
    private Users idUser;
    @OneToMany(mappedBy = "idOperator")
    private Collection<Abonent> abonentCollection;

    public Operator() {
    }

    public Operator(Integer idOperator) {
        this.idOperator = idOperator;
    }

    public Integer getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(Integer idOperator) {
        this.idOperator = idOperator;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Collection<Abonent> getAbonentCollection() {
        return abonentCollection;
    }

    public void setAbonentCollection(Collection<Abonent> abonentCollection) {
        this.abonentCollection = abonentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperator != null ? idOperator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operator)) {
            return false;
        }
        Operator other = (Operator) object;
        if ((this.idOperator == null && other.idOperator != null) || (this.idOperator != null && !this.idOperator.equals(other.idOperator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Operator[ idOperator=" + idOperator + " ]";
    }
    
}
