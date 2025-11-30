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
@Table(name = "Technician")
@NamedQueries({
    @NamedQuery(name = "Technician.findAll", query = "SELECT t FROM Technician t"),
    @NamedQuery(name = "Technician.findByIdTechnician", query = "SELECT t FROM Technician t WHERE t.idTechnician = :idTechnician")})
public class Technician implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTechnician")
    private Integer idTechnician;
    @JsonIgnore       @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne
    private Users idUser;
    @OneToMany(mappedBy = "idTechnician")
    private Collection<Remont> remontCollection;

    public Technician() {
    }

    public Technician(Integer idTechnician) {
        this.idTechnician = idTechnician;
    }

    public Integer getIdTechnician() {
        return idTechnician;
    }

    public void setIdTechnician(Integer idTechnician) {
        this.idTechnician = idTechnician;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Collection<Remont> getRemontCollection() {
        return remontCollection;
    }

    public void setRemontCollection(Collection<Remont> remontCollection) {
        this.remontCollection = remontCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTechnician != null ? idTechnician.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Technician)) {
            return false;
        }
        Technician other = (Technician) object;
        if ((this.idTechnician == null && other.idTechnician != null) || (this.idTechnician != null && !this.idTechnician.equals(other.idTechnician))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Technician[ idTechnician=" + idTechnician + " ]";
    }
    
}
