package it.tss.bkmapp;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
@Tag(name = "Verifica stato servizio", description = "Verifica se il servizio è attivo")
@PermitAll
public class PingResource {

    @Inject
    @ConfigProperty(name = "ping.message")
    String message;    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response ping() {
        return Response.status(Response.Status.OK)
                .entity(this.message + " powered by Jakarta EE 8 with MicroProfile 3+!")
                .build();
    }

}
