/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.boundary;

import it.tss.blogapp.control.TagStore;
import it.tss.blogapp.entity.Tag;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("/tags")
public class TagsResources {
    
    @Inject
    TagStore store;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> all(){
        return store.all();
    }
    
    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Tag findByName(@QueryParam("name") String name){
        return store.byName(name).orElseThrow(() ->new NotFoundException("tag non trovato"));
    }
    
    
}
