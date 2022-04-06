package airhacks.service.ping.boundary;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author airhacks.com
 */
public class PingResourceIT {

    private PingResourceClient client;
    URI uri;
    
    @BeforeEach
    public void init() {
        this.uri = URI.create("http://localhost:8080/blogapp/resources/");
        this.client = RestClientBuilder.
                newBuilder().
                baseUri(uri).
                build(PingResourceClient.class);

    }

    @Test
    public void ping() {
        Response response = this.client.ping();
        int status = response.getStatus();
        assertEquals(200, status);
        String message = response.readEntity(String.class);
        assertNotNull(message);
        System.out.println(message);
        
    }
    
    @Test
    public void pingStandardClient() {
        Client stdClient = ClientBuilder.newClient();
        WebTarget wt = stdClient
                .target(this.uri)
                .path("ping");
        Response response = wt.request(MediaType.TEXT_PLAIN).get();
        int status = response.getStatus();
        assertEquals(200, status);
        String message = response.readEntity(String.class);
        assertNotNull(message);
        System.out.println(message);
        
    }
}