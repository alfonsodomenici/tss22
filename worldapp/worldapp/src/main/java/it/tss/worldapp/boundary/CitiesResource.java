/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.worldapp.boundary;

import it.tss.worldapp.entity.City;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tss
 */
@Transactional(Transactional.TxType.REQUIRES_NEW)
@RequestScoped
@Path("/cities")
public class CitiesResource {
    
    @PersistenceContext
    EntityManager em;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("country") @DefaultValue("") String country,
            @QueryParam("city") String city){
        var tmpResult= em.createNamedQuery(City.FIND_BY_COUNTRY,City.class)
                .setParameter("country", "%" + country + "%")
                .getResultStream();
        
        var result = city == null ? tmpResult.collect(Collectors.toList()) : 
                tmpResult.filter(v -> v.getName().trim().toLowerCase().equals(city.trim().toLowerCase()))
                .collect(Collectors.toList());
        
        return Response.ok(result).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid City entity){
        System.out.println("nuova città: " + entity);
        //var saved = em.merge(entity);
        return Response.status(Response.Status.CREATED)
                .entity(entity)
                .build();
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id){
        em.remove(em.find(City.class, id));
        return Response.noContent().build();
    }
}
