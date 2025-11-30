/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mavenproject1.mavenproject1.entity;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author 8277
 */
@Entity
@Table(name = "ApplicationType")
@NamedQueries({
    @NamedQuery(name = "ApplicationType.findAll", query = "SELECT a FROM ApplicationType a"),
    @NamedQuery(name = "ApplicationType.findByIdApplicationType", query = "SELECT a FROM ApplicationType a WHERE a.idApplicationType = :idApplicationType"),
    @NamedQuery(name = "ApplicationType.findByName", query = "SELECT a FROM ApplicationType a WHERE a.name = :name"),
    @NamedQuery(name = "ApplicationType.findByNotes", query = "SELECT a FROM ApplicationType a WHERE a.notes = :notes")})
public class ApplicationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApplicationType")
    private Integer idApplicationType;
    @Column(name = "Name")
    private String name;
    @Column(name = "Notes")
    private String notes;
    @OneToMany(mappedBy = "idApplicationType")
    private Collection<Applications> applicationsCollection;

    public ApplicationType() {
    }

    public ApplicationType(Integer idApplicationType) {
        this.idApplicationType = idApplicationType;
    }

    public Integer getIdApplicationType() {
        return idApplicationType;
    }

    public void setIdApplicationType(Integer idApplicationType) {
        this.idApplicationType = idApplicationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Collection<Applications> getApplicationsCollection() {
        return applicationsCollection;
    }

    public void setApplicationsCollection(Collection<Applications> applicationsCollection) {
        this.applicationsCollection = applicationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApplicationType != null ? idApplicationType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationType)) {
            return false;
        }
        ApplicationType other = (ApplicationType) object;
        if ((this.idApplicationType == null && other.idApplicationType != null) || (this.idApplicationType != null && !this.idApplicationType.equals(other.idApplicationType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.ApplicationType[ idApplicationType=" + idApplicationType + " ]";
    }
    
}
