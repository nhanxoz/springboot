/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.sbrestful.repository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import stackjava.com.sbrestful.entities.Cart;
import stackjava.com.sbrestful.entities.Category;
/**
 *
 * @author Admin
 */
@Repository
public interface CartRepository  extends JpaRepository<Cart, Long> {
@Query(value="select id from Carts where user_id =? ", nativeQuery=true)
      public Long findByUser_id(Long id);
      

} 