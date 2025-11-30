/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mavenproject1.mavenproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import jakarta.persistence.Table;

/**
 *
 * @author 8277
 */
@Entity
@Table(name = "HomePhone")
@NamedQueries({
    @NamedQuery(name = "HomePhone.findAll", query = "SELECT h FROM HomePhone h"),
    @NamedQuery(name = "HomePhone.findByIdHomePhone", query = "SELECT h FROM HomePhone h WHERE h.idHomePhone = :idHomePhone"),
    @NamedQuery(name = "HomePhone.findByName", query = "SELECT h FROM HomePhone h WHERE h.name = :name"),
    @NamedQuery(name = "HomePhone.findByType", query = "SELECT h FROM HomePhone h WHERE h.type = :type")})
public class HomePhone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHomePhone")
    private Integer idHomePhone;
    @Column(name = "Name")
    private String name;
    @Column(name = "Type")
    private String type;
    @JsonIgnore       @JoinColumn(name = "idServices", referencedColumnName = "idServices")
    @ManyToOne
    private Services idServices;

    public HomePhone() {
    }

    public HomePhone(Integer idHomePhone) {
        this.idHomePhone = idHomePhone;
    }

    public Integer getIdHomePhone() {
        return idHomePhone;
    }

    public void setIdHomePhone(Integer idHomePhone) {
        this.idHomePhone = idHomePhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Services getIdServices() {
        return idServices;
    }

    public void setIdServices(Services idServices) {
        this.idServices = idServices;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHomePhone != null ? idHomePhone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HomePhone)) {
            return false;
        }
        HomePhone other = (HomePhone) object;
        if ((this.idHomePhone == null && other.idHomePhone != null) || (this.idHomePhone != null && !this.idHomePhone.equals(other.idHomePhone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.HomePhone[ idHomePhone=" + idHomePhone + " ]";
    }
    
}
