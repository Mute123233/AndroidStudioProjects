/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mavenproject1.mavenproject1;

import com.mavenproject1.mavenproject1.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author 8277
 */
@SpringBootApplication()
@ComponentScan(basePackageClasses=MainController.class)
public class Mavenproject1 {
    public static void main(String[] args) {
        SpringApplication.run(Mavenproject1.class, args);
    }
}
