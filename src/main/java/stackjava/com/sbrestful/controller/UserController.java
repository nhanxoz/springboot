/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackjava.com.sbrestful.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stackjava.com.sbrestful.entities.Register;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/apiAdmin")
@CrossOrigin
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/Customer", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        String sql = "Select * from(select COUNT(*) Customer from users) B, (select COUNT(*) NewRegister \n"
                + "from users where datediff(day, convert(datetime, createday, 103), getdate()) < 7) A";
        List<Register> cus = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Register.class));
        return new ResponseEntity<>(cus, HttpStatus.OK);
    }
}
