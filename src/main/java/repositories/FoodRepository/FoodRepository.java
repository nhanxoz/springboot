/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.FoodRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import stackjava.com.sbrestful.entities.Food;

/**
 *
 * @author ADMIN
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
  Optional<Food> findByName(String name);
  
  Boolean deleteFoodById(Integer Id);
  @Query(value = "SELECT coalesce(max(id), 0) FROM Food") 
    public Integer getMaxId();
  
}
