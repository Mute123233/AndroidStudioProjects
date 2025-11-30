/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mavenproject1.mavenproject1.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 8277
 */
@Entity
@Table(name = "Users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdUser", query = "SELECT u FROM Users u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname"),
    @NamedQuery(name = "Users.findByPatronymic", query = "SELECT u FROM Users u WHERE u.patronymic = :patronymic"),
    @NamedQuery(name = "Users.findBySnils", query = "SELECT u FROM Users u WHERE u.snils = :snils"),
    @NamedQuery(name = "Users.findByPassportData", query = "SELECT u FROM Users u WHERE u.passportData = :passportData"),
    @NamedQuery(name = "Users.findByBirthDate", query = "SELECT u FROM Users u WHERE u.birthDate = :birthDate"),
    @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
    @NamedQuery(name = "Users.findByEmploymentDate", query = "SELECT u FROM Users u WHERE u.employmentDate = :employmentDate"),
    @NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByPhotoEquipment", query = "SELECT u FROM Users u WHERE u.photoEquipment = :photoEquipment"),
    @NamedQuery(name = "Users.findByCode", query = "SELECT u FROM Users u WHERE u.code = :code"),
    @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "SNILS")
    private String snils;
    @Column(name = "PassportData")
    private String passportData;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "EmploymentDate")
    @Temporal(TemporalType.DATE)
    private Date employmentDate;
    @Column(name = "Login")
    private String login;
    @Column(name = "Password")
    private String password;
    @Column(name = "PhotoEquipment")
    private String photoEquipment;
    @Column(name = "code")
    private String code;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "idUser")
    private Collection<Operator> operatorCollection;
    @OneToMany(mappedBy = "idUser")
    private Collection<Supervisor> supervisorCollection;
    @OneToMany(mappedBy = "idUser")
    private Collection<Technician> technicianCollection;

    public Users() {
    }

    public Users(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoEquipment() {
        return photoEquipment;
    }

    public void setPhotoEquipment(String photoEquipment) {
        this.photoEquipment = photoEquipment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<Operator> getOperatorCollection() {
        return operatorCollection;
    }

    public void setOperatorCollection(Collection<Operator> operatorCollection) {
        this.operatorCollection = operatorCollection;
    }

    public Collection<Supervisor> getSupervisorCollection() {
        return supervisorCollection;
    }

    public void setSupervisorCollection(Collection<Supervisor> supervisorCollection) {
        this.supervisorCollection = supervisorCollection;
    }

    public Collection<Technician> getTechnicianCollection() {
        return technicianCollection;
    }

    public void setTechnicianCollection(Collection<Technician> technicianCollection) {
        this.technicianCollection = technicianCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Users[ idUser=" + idUser + " ]";
    }
    
}
