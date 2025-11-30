/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mavenproject1.mavenproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 8277
 */
@Entity
@Table(name = "AbonentServices")
@NamedQueries({
    @NamedQuery(name = "AbonentServices.findAll", query = "SELECT a FROM AbonentServices a"),
    @NamedQuery(name = "AbonentServices.findByIdAbonentServices", query = "SELECT a FROM AbonentServices a WHERE a.idAbonentServices = :idAbonentServices"),
    @NamedQuery(name = "AbonentServices.findByStartDate", query = "SELECT a FROM AbonentServices a WHERE a.startDate = :startDate"),
    @NamedQuery(name = "AbonentServices.findByEndDate", query = "SELECT a FROM AbonentServices a WHERE a.endDate = :endDate")})
public class AbonentServices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAbonentServices")
    private Integer idAbonentServices;
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JsonIgnore       @JoinColumn(name = "idAbonent", referencedColumnName = "idAbonent")
    @ManyToOne
    private Abonent idAbonent;
    @JsonIgnore       @JoinColumn(name = "idServices", referencedColumnName = "idServices")
    @ManyToOne
    private Services idServices;

    public AbonentServices() {
    }

    public AbonentServices(Integer idAbonentServices) {
        this.idAbonentServices = idAbonentServices;
    }

    public Integer getIdAbonentServices() {
        return idAbonentServices;
    }

    public void setIdAbonentServices(Integer idAbonentServices) {
        this.idAbonentServices = idAbonentServices;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Abonent getIdAbonent() {
        return idAbonent;
    }

    public void setIdAbonent(Abonent idAbonent) {
        this.idAbonent = idAbonent;
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
        hash += (idAbonentServices != null ? idAbonentServices.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbonentServices)) {
            return false;
        }
        AbonentServices other = (AbonentServices) object;
        if ((this.idAbonentServices == null && other.idAbonentServices != null) || (this.idAbonentServices != null && !this.idAbonentServices.equals(other.idAbonentServices))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.AbonentServices[ idAbonentServices=" + idAbonentServices + " ]";
    }
    
}
