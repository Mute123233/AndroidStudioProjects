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
@Table(name = "Supervisor")
@NamedQueries({
    @NamedQuery(name = "Supervisor.findAll", query = "SELECT s FROM Supervisor s"),
    @NamedQuery(name = "Supervisor.findByIdSupervisor", query = "SELECT s FROM Supervisor s WHERE s.idSupervisor = :idSupervisor")})
public class Supervisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSupervisor")
    private Integer idSupervisor;
    @JsonIgnore       @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne
    private Users idUser;

    public Supervisor() {
    }

    public Supervisor(Integer idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Integer getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Integer idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSupervisor != null ? idSupervisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.idSupervisor == null && other.idSupervisor != null) || (this.idSupervisor != null && !this.idSupervisor.equals(other.idSupervisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Supervisor[ idSupervisor=" + idSupervisor + " ]";
    }
    
}
