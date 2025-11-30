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
@Table(name = "Remont")
@NamedQueries({
    @NamedQuery(name = "Remont.findAll", query = "SELECT r FROM Remont r"),
    @NamedQuery(name = "Remont.findByIdRemont", query = "SELECT r FROM Remont r WHERE r.idRemont = :idRemont"),
    @NamedQuery(name = "Remont.findByType", query = "SELECT r FROM Remont r WHERE r.type = :type")})
public class Remont implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRemont")
    private Integer idRemont;
    @Column(name = "Type")
    private String type;
    @JsonIgnore       @JoinColumn(name = "idEquipment", referencedColumnName = "idEquipment")
    @ManyToOne
    private Equipment idEquipment;
    @JsonIgnore       @JoinColumn(name = "idServices", referencedColumnName = "idServices")
    @ManyToOne
    private Services idServices;
    @JsonIgnore       @JoinColumn(name = "idTechnician", referencedColumnName = "idTechnician")
    @ManyToOne
    private Technician idTechnician;

    public Remont() {
    }

    public Remont(Integer idRemont) {
        this.idRemont = idRemont;
    }

    public Integer getIdRemont() {
        return idRemont;
    }

    public void setIdRemont(Integer idRemont) {
        this.idRemont = idRemont;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Equipment getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(Equipment idEquipment) {
        this.idEquipment = idEquipment;
    }

    public Services getIdServices() {
        return idServices;
    }

    public void setIdServices(Services idServices) {
        this.idServices = idServices;
    }

    public Technician getIdTechnician() {
        return idTechnician;
    }

    public void setIdTechnician(Technician idTechnician) {
        this.idTechnician = idTechnician;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRemont != null ? idRemont.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remont)) {
            return false;
        }
        Remont other = (Remont) object;
        if ((this.idRemont == null && other.idRemont != null) || (this.idRemont != null && !this.idRemont.equals(other.idRemont))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Remont[ idRemont=" + idRemont + " ]";
    }
    
}
