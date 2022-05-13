/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.boundary;

import java.net.URI;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author tss
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersResourceIT {
    static UsersResourceClient client;
    static  private String token;
    static  private long id;

    public UsersResourceIT() {
        System.out.println("test costructor...");
    }
    
    
    @BeforeAll
    public static void init(){
        URI baseUri = URI.create("http://localhost:8080/blogapp/resources/"); 
        client = RestClientBuilder.newBuilder()
                .baseUri(baseUri)
                .build(UsersResourceClient.class);
    }
    
    @Test
    @Order(1)
    public void registration(){
        JsonObject user = Json.createObjectBuilder()
                .add("first_name", "lucia")
                .add("last_name", "verdi")
                .add("email", "verdi@gmail.com")
                .add("pwd", "verdi")
                .build();
        
        Response response = this.client.create(user);
        Assertions.assertEquals(201,response.getStatus());
        JsonObject userCreated = response.readEntity(JsonObject.class);
        Assertions.assertNotNull(userCreated);
        System.out.println(userCreated);
        id = userCreated.getJsonNumber("id").longValue();
    }
    
    @Test
    @Order(2)
    public void login(){
        JsonObject credential = Json.createObjectBuilder()
                .add("usr", "verdi@gmail.com")
                .add("pwd", "verdi")
                .build();
        JsonObject result = client.login(credential);
        Assertions.assertTrue(result.containsKey("jwt"));
        token = result.getString("jwt");
        System.out.println(token);
    }
    
    
    
    @Test
    @Order(3)
    public void delete(){
        System.out.println("token: " + token);
        System.out.println("id: " + id);
        Response response = client.delete("Bearer " + token.trim(), id);
        Assertions.assertEquals(204,response.getStatus());
    }
    
}
