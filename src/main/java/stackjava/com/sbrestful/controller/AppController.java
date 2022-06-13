/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package stackjava.com.sbrestful.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stackjava.com.sbrestful.entities.Blog;
import stackjava.com.sbrestful.entities.Cart;
import stackjava.com.sbrestful.entities.CartFood;
import stackjava.com.sbrestful.entities.Food;
import stackjava.com.sbrestful.entities.Order;
import stackjava.com.sbrestful.repository.BlogRepository;
import stackjava.com.sbrestful.repository.CartRepository;
import stackjava.com.sbrestful.repository.OrderRepository;
import stackjava.com.sbrestful.request.AddFoodRequest;
import stackjava.com.sbrestful.response.CategoryResponse;
import stackjava.com.sbrestful.response.BlogResponse;
import stackjava.com.sbrestful.response.OrderResponse;
/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class AppController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
@Autowired
    BlogRepository blogRepository ;
@Autowired
    CartRepository cartRepository;
@Autowired
    OrderRepository orderRepository;
public class OrderShortInfor{
              public long id;
              public long created_time;
              public String payment_method;
              public int status;
              public int total_price;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getCreated_time() {
            return created_time;
        }

        public void setCreated_time(long created_time) {
            this.created_time = created_time;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTotal_price() {
            return total_price;
        }

        public void setTotal_price(int total_price) {
            this.total_price = total_price;
        }
              
          }
    //--GET BLOG--//
    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public ResponseEntity getAllBlog() {

	    List<Blog> listBlog = blogRepository.findAll();
            BlogResponse blogResponse = new BlogResponse();
            blogResponse.setData(listBlog);
	    return new ResponseEntity<>(blogResponse, HttpStatus.OK);
    }
    //--ADD CART--//
    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public ResponseEntity addCart(long id_user, long id_food) {
            
	    Long cart = cartRepository.findByUser_id(id_user);
            String sql = "select * from cart_food \n"
                + " where cart_id ="+cart+ " and food_id="+id_food;
              
            AddFoodRequest food = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(AddFoodRequest.class)).get(0);
	    if (food == null) {
                sql = "insert into cart_food (cart_id, food_id, quantity) values ("+Long.toString(cart) +","
                        +Long.toString(id_food)+",1";
                jdbcTemplate.update(sql);
	    }
            else{
                sql = "update cart_food set quantity = quantity+1 where cart_id = "+ Long.toString(food.getCart_id()) +" and food_id = "
                        +Long.toString(food.getFood_id());
                jdbcTemplate.update(sql);
            }
            
	    return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

     //--UPDATE CART--//
    @RequestMapping(value = "/updateCart", method = RequestMethod.POST)
    public ResponseEntity updateCart(long id_user, long id_food, int quantity) {
            
	        Long cart = cartRepository.findByUser_id(id_user);
                String sql = "update cart_food set quantity="+ Integer.toString(quantity) +" where cart_id = "+ Long.toString(cart) +" and food_id ="
                        +Long.toString(id_food);
                jdbcTemplate.update(sql);
            
            
	    return new ResponseEntity<>("Success!", HttpStatus.OK);
    }
    
 
//	  /* ---------------- GET ALL ORDER ------------------------ */
	  @RequestMapping(value = "/allOrder", method = RequestMethod.POST)
	  public ResponseEntity<List<OrderShortInfor>> getAllOrder(Long user_id) {
            String sql= "select id, created_time,  payment_method, status, total_price from orders where user_id="+Long.toString(user_id);
            List<OrderShortInfor> listOrder = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(OrderShortInfor.class));
            
            
	    return new ResponseEntity<>(listOrder, HttpStatus.OK);
	  }
    
          
}
