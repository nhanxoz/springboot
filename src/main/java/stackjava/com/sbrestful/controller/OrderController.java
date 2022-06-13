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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import stackjava.com.sbrestful.entities.Food;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAll() {
        List<Order> listOrder = orderRepository.findAll();
        return new ResponseEntity<>(listOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/detailOrder", method = RequestMethod.GET)
    public ResponseEntity Detail(int id) {
        String sql = "select food.name, food.alias, food.image, food.origin_price, food.promotion_price, order_food.quantity\n"
                + "from order_food, food\n"
                + "where order_food.food_id = food.id\n"
                + "and order_food.order_id="+id;
        List<Food> details = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Food.class));
        return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
