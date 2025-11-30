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
@Table(name = "Equipment")
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e"),
    @NamedQuery(name = "Equipment.findByIdEquipment", query = "SELECT e FROM Equipment e WHERE e.idEquipment = :idEquipment"),
    @NamedQuery(name = "Equipment.findByName", query = "SELECT e FROM Equipment e WHERE e.name = :name"),
    @NamedQuery(name = "Equipment.findByPhoto", query = "SELECT e FROM Equipment e WHERE e.photo = :photo")})
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipment")
    private Integer idEquipment;
    @Column(name = "Name")
    private String name;
    @Column(name = "Photo")
    private String photo;
    @OneToMany(mappedBy = "idEquipment")
    private Collection<Remont> remontCollection;

    public Equipment() {
    }

    public Equipment(Integer idEquipment) {
        this.idEquipment = idEquipment;
    }

    public Integer getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(Integer idEquipment) {
        this.idEquipment = idEquipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Collection<Remont> getRemontCollection() {
        return remontCollection;
    }

    public void setRemontCollection(Collection<Remont> remontCollection) {
        this.remontCollection = remontCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipment != null ? idEquipment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.idEquipment == null && other.idEquipment != null) || (this.idEquipment != null && !this.idEquipment.equals(other.idEquipment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mavenproject1.mavenproject1.entity.Equipment[ idEquipment=" + idEquipment + " ]";
    }
    
}
