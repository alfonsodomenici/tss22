/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp;

import it.tss.blogapp.control.UserStore;
import it.tss.blogapp.entity.User;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named("indexCtx")
@ViewScoped
public class IndexController implements Serializable {
    
    @Inject
    UserStore store;

    
    private List<User> users;
    
    /*
    risponde al click del bottone carica
    */
    public void loadUsers(){
        System.out.println("loadUsers()..");
        this.users = store.all();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    } 
}
