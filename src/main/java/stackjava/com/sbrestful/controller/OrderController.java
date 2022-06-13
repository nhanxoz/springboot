/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackjava.com.sbrestful.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stackjava.com.sbrestful.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import stackjava.com.sbrestful.entities.Order;
/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/apiFood")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
     @Autowired
     OrderRepository orderRepository;
     @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }
     @GetMapping("/orders")
     public ResponseEntity<List<Order>> getAll(){
         List<Order> listOrder = orderRepository.findAll();
         return new ResponseEntity<>(listOrder, HttpStatus.OK);
     }
}

