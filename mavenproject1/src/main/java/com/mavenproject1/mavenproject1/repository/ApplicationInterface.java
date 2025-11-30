/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mavenproject1.mavenproject1.repository;


import com.mavenproject1.mavenproject1.entity.Applications;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 8277
 */
@Repository
public interface ApplicationInterface extends CrudRepository<Applications,Integer>{
    
}
