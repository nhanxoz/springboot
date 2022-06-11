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
import repositories.FoodRepository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import stackjava.com.sbrestful.entities.Order;
/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/apiFood")
@CrossOrigin
public class OrderController {
     @Autowired
     OrderRepository orderRepository;
     
     @RequestMapping(value = "/orders", method = RequestMethod.GET)
     public ResponseEntity<List<Order>> getAll(){
         List<Order> listOrder = orderRepository.findAll();
         return new ResponseEntity<>(listOrder, HttpStatus.OK);
     }
}
