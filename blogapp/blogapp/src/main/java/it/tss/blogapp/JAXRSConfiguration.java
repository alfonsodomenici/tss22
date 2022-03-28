package it.tss.blogapp;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */
@ApplicationPath("resources")
@OpenAPIDefinition(info = @Info(
            title = "Blogapp application", 
            version = "1.0.0", 
            contact = @Contact(
                    name = "tss dev", 
                    email = "tssdev@gmail.com",
                    url = "http://ciacformazione.it")
            ),
            servers = {
                @Server(url = "/blogapp",description = "localhost")
            })
public class JAXRSConfiguration extends Application {

}
