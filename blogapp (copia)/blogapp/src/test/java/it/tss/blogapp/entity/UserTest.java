package it.tss.blogapp.entity;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tss
 */
public class UserTest {

    private Validator validator;
    Set<ConstraintViolation<User>> constraintViolations;
    
    @BeforeEach
    public void init(){
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void testNotValid() {

        User u = new User();
        
        //firstname
        u.setFirstName("");

        constraintViolations
                = validator.validate(u);

        
        boolean anyMatch = constraintViolations.stream()
                .anyMatch(v -> v.getPropertyPath().toString()
                        .equals("firstName"));
        
        Assertions.assertTrue(anyMatch);
        
        //lastname
        u.setLastName("   ");
        constraintViolations
                = validator.validate(u);
        
        anyMatch = constraintViolations.stream()
                .anyMatch(v -> v.getPropertyPath().toString()
                        .equals("lastName"));
                
        Assertions.assertTrue(anyMatch);
        

        //email
        u.setLastName("xx.hotmail.it");
        constraintViolations
                = validator.validate(u);
        
        anyMatch = constraintViolations.stream()
                .anyMatch(v -> v.getPropertyPath().toString()
                        .equals("email"));
                
        Assertions.assertTrue(anyMatch);
        
        //password
        u.setPwd("123");
        constraintViolations
                = validator.validate(u);
        
        anyMatch = constraintViolations.stream()
                .anyMatch(v -> v.getPropertyPath().toString()
                        .equals("pwd"));
                
        Assertions.assertTrue(anyMatch);
    }
    
    @Test
    public void testValid(){
        User user = new User();
        user.setFirstName("mario");
        Assertions.assertTrue(user.getFirstName()!= null && user.getFirstName().equals("mario"));
        
        user.setLastName("rossi");
        Assertions.assertTrue(user.getLastName()!= null && user.getLastName().equals("rossi"));
        
        user.setEmail("rossi@hotmail.it");
        Assertions.assertTrue(user.getEmail()!= null && user.getEmail().equals("rossi@hotmail.it"));
        
        user.setPwd("12345");
        Assertions.assertTrue(user.getPwd()!= null && user.getPwd().equals("12345"));
        
        constraintViolations = validator.validate(user);
        
        Assertions.assertTrue(constraintViolations.isEmpty());

    }
}
