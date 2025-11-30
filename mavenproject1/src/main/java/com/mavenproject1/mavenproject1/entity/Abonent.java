/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mavenproject1.mavenproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 8277
 */
@Entity
@Table(name = "Abonent")
@NamedQueries({
    @NamedQuery(name = "Abonent.findAll", query = "SELECT a FROM Abonent a"),
    @NamedQuery(name = "Abonent.findByIdAbonent", query = "SELECT a FROM Abonent a WHERE a.idAbonent = :idAbonent"),
    @NamedQuery(name = "Abonent.findBySurname", query = "SELECT a FROM Abonent a WHERE a.surname = :surname"),
    @NamedQuery(name = "Abonent.findByName", query = "SELECT a FROM Abonent a WHERE a.name = :name"),
    @NamedQuery(name = "Abonent.findByPatronymic", query = "SELECT a FROM Abonent a WHERE a.patronymic = :patronymic"),
    @NamedQuery(name = "Abonent.findByDownloadDate", query = "SELECT a FROM Abonent a WHERE a.downloadDate = :downloadDate"),
    @NamedQuery(name = "Abonent.findByAvailabilityBlocker", query = "SELECT a FROM Abonent a WHERE a.availabilityBlocker = :availabilityBlocker"),
    @NamedQuery(name = "Abonent.findByDebt", query = "SELECT a FROM Abonent a WHERE a.debt = :debt"),
    @NamedQuery(name = "Abonent.findByNotes", query = "SELECT a FROM Abonent a WHERE a.notes = :notes")})
public class Abonent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAbonent")
    private Integer idAbonent;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Name")
    private String name;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "DownloadDate")
    @Temporal(TemporalType.DATE)
    private Date downloadDate;
    @Basic(optional = false)
    @Column(name = "AvailabilityBlocker")
    private int availabilityBlocker;
    @Column(name = "Debt")
    private String debt;
    @Column(name = "Notes")
    private String notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAbonent")
    private Collection<Applications> applicationsCollection;
    @JsonIgnore       @JoinColumn(name = "idOperator", referencedColumnName = "idOperator")
    @ManyToOne
    private Operator idOperator;
    @OneToMany(mappedBy = "idAbonent")
    private Collection<AbonentServices> abonentServicesCollection;

    public Abonent() {
    }

    public Abonent(Integer idAbonent) {
        this.idAbonent = idAbonent;
    }

    public Abonent(Integer idAbonent, int availabilityBlocker) {
        this.idAbonent = idAbonent;
        this.availabilityBlocker = availabilityBlocker;
    }

    public Integer getIdAbonent() {
        return idAbonent;
    }

    public void setIdAbonent(Integer idAbonent) {
        this.idAbonent = idAbonent;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public int getAvailabilityBlocker() {
        return availabilityBlocker;
    }

    public void setAvailabilityBlocker(int availabilityBlocker) {
        this.availabilityBlocker = availabilityBlocker;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
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

    public Operator getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(Operator idOperator) {
        this.idOperator = idOperator;
    }

    public Collection<AbonentServices> getAbonentServicesCollection() {
        return abonentServicesCollection;
    }

    public void setAbonentServicesCollection(Collection<AbonentServices> abonentServicesCollection) {
        this.abonentServicesCollection = abonentServicesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAbonent != null ? idAbonent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonent)) {
            return false;
        }
        Abonent other = (Abonent) object;
        if ((this.idAbonent == null && other.idAbonent != null) || (this.idAbonent != null && !this.idAbonent.equals(other.idAbonent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Abonent[ idAbonent=" + idAbonent + " ]";
    }
    
}
