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
@Table(name = "Services")
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByIdServices", query = "SELECT s FROM Services s WHERE s.idServices = :idServices"),
    @NamedQuery(name = "Services.findByName", query = "SELECT s FROM Services s WHERE s.name = :name"),
    @NamedQuery(name = "Services.findByNotes", query = "SELECT s FROM Services s WHERE s.notes = :notes")})
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idServices")
    private Integer idServices;
    @Column(name = "Name")
    private String name;
    @Column(name = "Notes")
    private String notes;
    @OneToMany(mappedBy = "idServices")
    private Collection<Remont> remontCollection;
    @OneToMany(mappedBy = "idServices")
    private Collection<AbonentServices> abonentServicesCollection;
    @OneToMany(mappedBy = "idServices")
    private Collection<HomePhone> homePhoneCollection;
    @OneToMany(mappedBy = "idServices")
    private Collection<Internet> internetCollection;

    public Services() {
    }

    public Services(Integer idServices) {
        this.idServices = idServices;
    }

    public Integer getIdServices() {
        return idServices;
    }

    public void setIdServices(Integer idServices) {
        this.idServices = idServices;
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

    public Collection<Remont> getRemontCollection() {
        return remontCollection;
    }

    public void setRemontCollection(Collection<Remont> remontCollection) {
        this.remontCollection = remontCollection;
    }

    public Collection<AbonentServices> getAbonentServicesCollection() {
        return abonentServicesCollection;
    }

    public void setAbonentServicesCollection(Collection<AbonentServices> abonentServicesCollection) {
        this.abonentServicesCollection = abonentServicesCollection;
    }

    public Collection<HomePhone> getHomePhoneCollection() {
        return homePhoneCollection;
    }

    public void setHomePhoneCollection(Collection<HomePhone> homePhoneCollection) {
        this.homePhoneCollection = homePhoneCollection;
    }

    public Collection<Internet> getInternetCollection() {
        return internetCollection;
    }

    public void setInternetCollection(Collection<Internet> internetCollection) {
        this.internetCollection = internetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServices != null ? idServices.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.idServices == null && other.idServices != null) || (this.idServices != null && !this.idServices.equals(other.idServices))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Services[ idServices=" + idServices + " ]";
    }
    
}
