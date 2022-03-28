/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.boundary;

import it.tss.blogapp.JAXRSConfiguration;
import it.tss.blogapp.control.PostStore;
import it.tss.blogapp.control.UserStore;
import it.tss.blogapp.entity.Post;
import it.tss.blogapp.entity.User;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author tss
 */
@Path("/users")
@Tag(name = "gestione utenti", description = "permette di gestire gli utenti di blogapp")
public class UsersResource {

    @Inject
    private UserStore store;

    @Inject
    PostStore postStore;

    @Context
    ResourceContext rc;

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Restituisce l'elenco di tutti gli utenti")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Elenco ritornato con successo")
    })
    public List<User> all() {
        return store.all();
    }

    @GET
    @Path("allslice")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray allSlice() {
        return store.all().stream().map(User::toJsonSlice).collect(JsonCollectors.toJsonArray());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Valid User entity) {
        store.save(entity);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@Valid User entity) {
        store.save(entity);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("id") Long id) {
        return store.find(id).orElseThrow(() -> new NotFoundException("user non trovato. id=" + id));
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        User found = store.find(id).orElseThrow(() -> new NotFoundException("user non trovato. id=" + id));
        store.delete(found.getId());
    }

    @GET
    @Path("{id}/posts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> posts(@PathParam("id") Long id) {
        return postStore.byUser(id);
    }

    @POST
    @Path("{id}/posts")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPost(@PathParam("id") Long id, @Valid Post entity) {
        postStore.save(entity);
    }
}
