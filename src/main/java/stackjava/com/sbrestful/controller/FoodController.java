/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackjava.com.sbrestful.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repositories.FoodRepository.FoodRepository;
import static stackjava.com.sbrestful.controller.UserRestController.mapUser;
import stackjava.com.sbrestful.entities.Food;
import stackjava.com.sbrestful.entities.User;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/apiFood")
@CrossOrigin
public class FoodController {
	
            @Autowired
            FoodRepository foodRepository;
	  
	  /* ---------------- GET ALL FOOD ------------------------ */
	  @RequestMapping(value = "/foods", method = RequestMethod.GET)
	  public ResponseEntity<FoodResponse> getAllFood() {
	    List<Food> listFood = foodRepository.findAll();
            FoodResponse foodResponse = new FoodResponse();
            foodResponse.setData(listFood);
	    return new ResponseEntity<>(foodResponse, HttpStatus.OK);
	  }
          /* ---------------- CREATE NEW FOOD ------------------------ */
	  @RequestMapping(value = "/foods", method = RequestMethod.POST)
          @Transactional
	  public ResponseEntity<String> createFood(@RequestBody Food food) {
              Integer newID = foodRepository.getMaxId()+1;
              food.setId(newID);
	    foodRepository.save(food);
	    return new ResponseEntity<>("Created!", HttpStatus.CREATED);
	  }
	  /* ---------------- DELETE FOOD ------------------------ */
	  @RequestMapping(value = "/foods/{id}", method = RequestMethod.DELETE)
	  public ResponseEntity<String> deleteFoodById(@PathVariable Integer id) {
	        Optional<Food> food = foodRepository.findById(id);
	    if (food == null) {
	      return new ResponseEntity<String>("Not Found Food", HttpStatus.OK);
	    }
	    
	    foodRepository.deleteById(id);
	    return new ResponseEntity<>("Deleted!", HttpStatus.OK);
	  }
	  
	  
}