/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.boundary;

import it.tss.bkmapp.control.BkmStore;
import it.tss.bkmapp.control.TagStore;
import it.tss.bkmapp.entity.Bkm;
import it.tss.bkmapp.entity.Tag;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author tss
 */
@Path("/bkms")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(
        name = "Gestione Bkms", description = "Permetti ad ogni utente di gestire i propri bkm"
)
@DenyAll
public class BkmsResource {

    @Inject
    BkmStore store;

    @Inject
    TagStore tagStore;

    @Inject
    JsonWebToken token;

    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("users")
    public Data<Bkm> search( @QueryParam("user_id") Long userId, @QueryParam("descr") String descr, @QueryParam("tag") String tag,
            @DefaultValue("1") @QueryParam("page") Integer page, @DefaultValue("10") @QueryParam("size") Integer size) {
        List<Bkm> search = store.search(userId, descr, tag, page, size);
        long searchCount = store.searchCount(userId, descr, tag);
        return new Data(search, searchCount);
    }
    */
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("users")
    public Bkm find(@PathParam("id") Long id) {
        Bkm found = store.find(id).orElseThrow(() -> new NotFoundException());
        checkOwner(found.getOwner().getId());
        return found;
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("users")
    public Bkm update(@PathParam("id") Long id, @Valid Bkm entity) {
        checkOwner(entity.getOwner().getId());
        entity.setId(id);
        return store.save(entity);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("users")
    public void delete(@PathParam("id") Long id) {
        Bkm todel = store.find(id).orElseThrow(() -> new NotFoundException());
        checkOwner(todel.getOwner().getId());
        store.delete(id);
    }

    @GET
    @Path("{id}/tags")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("users")
    public Set<Tag> tags(@PathParam("id") Long id) {
        Bkm found = store.find(id).orElseThrow(() -> new NotFoundException());
        return tagStore.byBkm(id);
    }

    @PATCH
    @Path("{id}/tags")
    @Consumes(MediaType.TEXT_PLAIN)
    @RolesAllowed("users")
    public void addTag(@PathParam("id") Long id, @NotBlank String tag) {
        Bkm found = store.find(id).orElseThrow(() -> new NotFoundException());
        checkOwner(found.getOwner().getId());
        store.addTag(found, tag);
    }

    @DELETE
    @Path("{id}/tags")
    @Consumes(MediaType.TEXT_PLAIN)
    @RolesAllowed("users")
    public void removeTag(@PathParam("id") Long id, String tag) {
        Bkm found = store.find(id).orElseThrow(() -> new NotFoundException());
        checkOwner(found.getOwner().getId());
        store.removeTag(id, tag);
    }
    
    private void checkOwner(Long userId){
        if (Long.parseLong(token.getSubject()) != userId) {
            System.out.println("id utente non corrispondente");
            throw new ForbiddenException();
        }
    }
}
