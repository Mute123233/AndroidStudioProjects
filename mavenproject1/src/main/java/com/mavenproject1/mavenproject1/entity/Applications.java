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
@Table(name = "Applications")
@NamedQueries({
    @NamedQuery(name = "Applications.findAll", query = "SELECT a FROM Applications a"),
    @NamedQuery(name = "Applications.findByIdApplication", query = "SELECT a FROM Applications a WHERE a.idApplication = :idApplication"),
    @NamedQuery(name = "Applications.findByApplicationsDate", query = "SELECT a FROM Applications a WHERE a.applicationsDate = :applicationsDate"),
    @NamedQuery(name = "Applications.findByNote", query = "SELECT a FROM Applications a WHERE a.note = :note")})
public class Applications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApplication")
    private Integer idApplication;
    @Column(name = "ApplicationsDate")
    @Temporal(TemporalType.DATE)
    private Date applicationsDate;
    @Column(name = "Note")
    private String note;
    @JsonIgnore       @JoinColumn(name = "idAbonent", referencedColumnName = "idAbonent")
    @ManyToOne(optional = false)
    private Abonent idAbonent;
    @JsonIgnore       @JoinColumn(name = "idApplicationType", referencedColumnName = "idApplicationType")
    @ManyToOne
    private ApplicationType idApplicationType;
    @JsonIgnore       @JoinColumn(name = "idStatus", referencedColumnName = "idStatus")
    @ManyToOne
    private Status idStatus;

    public Applications() {
    }

    public Applications(Integer idApplication) {
        this.idApplication = idApplication;
    }

    public Integer getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(Integer idApplication) {
        this.idApplication = idApplication;
    }

    public Date getApplicationsDate() {
        return applicationsDate;
    }

    public void setApplicationsDate(Date applicationsDate) {
        this.applicationsDate = applicationsDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Abonent getIdAbonent() {
        return idAbonent;
    }

    public void setIdAbonent(Abonent idAbonent) {
        this.idAbonent = idAbonent;
    }

    public ApplicationType getIdApplicationType() {
        return idApplicationType;
    }

    public void setIdApplicationType(ApplicationType idApplicationType) {
        this.idApplicationType = idApplicationType;
    }

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApplication != null ? idApplication.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applications)) {
            return false;
        }
        Applications other = (Applications) object;
        if ((this.idApplication == null && other.idApplication != null) || (this.idApplication != null && !this.idApplication.equals(other.idApplication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Applications[ idApplication=" + idApplication + " ]";
    }
    
}
