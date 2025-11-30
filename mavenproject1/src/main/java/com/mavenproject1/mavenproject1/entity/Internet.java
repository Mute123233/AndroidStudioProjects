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
@Table(name = "Internet")
@NamedQueries({
    @NamedQuery(name = "Internet.findAll", query = "SELECT i FROM Internet i"),
    @NamedQuery(name = "Internet.findByIdInternet", query = "SELECT i FROM Internet i WHERE i.idInternet = :idInternet"),
    @NamedQuery(name = "Internet.findByName", query = "SELECT i FROM Internet i WHERE i.name = :name"),
    @NamedQuery(name = "Internet.findByType", query = "SELECT i FROM Internet i WHERE i.type = :type")})
public class Internet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInternet")
    private Integer idInternet;
    @Column(name = "Name")
    private String name;
    @Column(name = "Type")
    private String type;
    @JsonIgnore       @JoinColumn(name = "idServices", referencedColumnName = "idServices")
    @ManyToOne
    private Services idServices;

    public Internet() {
    }

    public Internet(Integer idInternet) {
        this.idInternet = idInternet;
    }

    public Integer getIdInternet() {
        return idInternet;
    }

    public void setIdInternet(Integer idInternet) {
        this.idInternet = idInternet;
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
        hash += (idInternet != null ? idInternet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Internet)) {
            return false;
        }
        Internet other = (Internet) object;
        if ((this.idInternet == null && other.idInternet != null) || (this.idInternet != null && !this.idInternet.equals(other.idInternet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Internet[ idInternet=" + idInternet + " ]";
    }
    
}
