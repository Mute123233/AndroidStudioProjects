/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mavenproject1.mavenproject1.repository;

import com.mavenproject1.mavenproject1.entity.Services;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 8277
 */
@Repository
public interface ServicesInterface extends CrudRepository<Services,Integer>{

     @Query("SELECT s.name, COUNT(a.idAbonent) FROM Services s LEFT JOIN s.abonentServicesCollection a GROUP BY s.name")
    List<Object[]> countAbonentsByService();


    
}
