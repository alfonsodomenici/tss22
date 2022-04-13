/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.worldapp.boundary;

import java.math.BigDecimal;
import java.net.URI;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.UriSelector;

/**
 *
 * @author tss
 */
public class CitiesResourceIT {

    CitiesResourceClient client;

    @BeforeEach
    public void init() {
        this.client = RestClientBuilder.newBuilder()
                .baseUri(URI.create("http://localhost:8080/worldapp/resources/"))
                .build(CitiesResourceClient.class);
    }

    @Test
    public void italianCities() {

        var response = client.search("italy", null);
        Assertions.assertEquals(200, response.getStatus());

        var data = response.readEntity(JsonArray.class);

        Assertions.assertFalse(data.isEmpty());

        var found = data.stream().map(v -> v.asJsonObject().getString("name"))
                .filter(v -> v.equals("Torino"))
                .findFirst();

        Assertions.assertTrue(found.isPresent());
    }

    @Test
    public void createIvreaCity() {
        var entity = Json.createObjectBuilder()
                .add("name", "Ivrea")
                .add("district", "Piemonte")
                .add("population", 40000)
                .add("country", Json.createObjectBuilder().add("code", "ITA"))
                .build();

        var response = client.create(entity);
        Assertions.assertEquals(201, response.getStatus());

        var id = response.readEntity(JsonObject.class)
                .getInt("id");

        var data = client.search("italy", "Ivrea").readEntity(JsonArray.class);

        Assertions.assertEquals(1, data.size());

        System.out.println(data.getJsonObject(0));

        response = client.delete(id);

        Assertions.assertEquals(204, response.getStatus());

        data = client.search("italy", "Ivrea").readEntity(JsonArray.class);

        Assertions.assertTrue(data.isEmpty());
    }

}
