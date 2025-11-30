/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mavenproject1.mavenproject1.repository;


import com.mavenproject1.mavenproject1.entity.Abonent;
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
public interface AbonentInterface extends CrudRepository<Abonent,Integer>{

 long countByAvailabilityBlocker(int value);

   @Query("SELECT a FROM Abonent a JOIN a.abonentServicesCollection s JOIN s.idServices serv WHERE serv.name = 'Интернет'")
    List<Abonent> findAbonentsByInternetService();
    
    
}
