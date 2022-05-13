/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.boundary;

import it.tss.bkmapp.JWTManager;
import it.tss.bkmapp.control.BkmStore;
import it.tss.bkmapp.control.UserStore;
import it.tss.bkmapp.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author tss
 */
@Path("/users")
@Tag(name = "Operazioni Utenti", description = "Login, Registrazione, Ricerca Utenti")
@DenyAll
public class UsersResource {

    @Inject
    private UserStore store;

    @Inject
    BkmStore bkmStore;

    @Context
    ResourceContext rc;

    @Context
    UriInfo uriInfo;

    @Inject
    JWTManager jwtManager;

    @Inject
    JsonWebToken token;

    @Claim(value = "sub")
    String sub;

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Login utente")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Login effettuata con successo",
                content = @Content(mediaType = MediaType.APPLICATION_JSON,
                        schema = @Schema(example = "{\"jwt\":asxdv...}"))),
        @APIResponse(responseCode = "401", description = "Login fallita")
    })
    @PermitAll
    public JsonObject login(@Valid Credential credential) {
        var u = store.login(credential).orElseThrow(() -> new NotAuthorizedException(
                Response.status(Response.Status.UNAUTHORIZED).build()));
        var jwt = jwtManager.generate(u);
        return Json.createObjectBuilder()
                .add("jwt", jwt)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Ricerca utenti")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Elenco ritornato con successo")
    })
    @RolesAllowed("users")
    public Data<User> search(@QueryParam("fname") String fname, @QueryParam("lname") String lname,
            @DefaultValue("1") @QueryParam("page") int page, @QueryParam("size") Integer size) {
        List<User> search = store.search(fname, lname, page, size);
        long searchCount = store.searchCount(fname, lname);
        return new Data<>(search, searchCount);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Permette la registrazione di un nuovo utente")
    @APIResponses({
        @APIResponse(responseCode = "201", description = "Nuovo utente creato con successo")
    })
    @PermitAll
    public Response create(@Valid User entity) {
        User saved = store.create(entity);
        return Response.status(Response.Status.CREATED)
                .entity(saved)
                .build();
    }
    
    @Path("{id}")
    @RolesAllowed("users")
    public UserResource find(@PathParam("id") Long id) {
        if (Long.parseLong(token.getSubject()) != id) {
            System.out.println("id utente non corrispondente");
            throw new ForbiddenException();
        }
        UserResource sub = rc.getResource(UserResource.class);
        sub.setId(id);
        return sub;
    }

}
