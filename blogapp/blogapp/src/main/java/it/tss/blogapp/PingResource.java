package it.tss.blogapp;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
@Tag(name = "Verifica stato servizio", description = "Verifica se il servizio è attivo")
public class PingResource {

    @Inject
    @ConfigProperty(name = "ping.message")
    String message;    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return this.message + " powered by Jakarta EE 8 with MicroProfile 3+!";
    }

}
