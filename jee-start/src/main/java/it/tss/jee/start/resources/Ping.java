/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jee.start.resources;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
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
@Path("ping")
public class Ping {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject ping( @QueryParam("language") @DefaultValue("it") String ln) {
        
        if(ln == null){
            
            //throw new BadRequestException("parametro language mancante");
            throw new BadRequestException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("motivo", "parametro language mancante")
                    .build());
            
        }
        
        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        switch (ln) {
            case "it":
                df = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss", Locale.ITALY);
                return Json.createObjectBuilder().add("ts","ping ok!! " + LocalDateTime.now().format(df)).build();
            case "en":
                df = DateTimeFormatter.ofPattern("yyyy-MM-dd hh.mm.ss", Locale.ENGLISH);
                return Json.createObjectBuilder().add("ts","ping ok!! " + LocalDateTime.now().format(df)).build();
            default:
                return Json.createObjectBuilder().add("ts","ping ok!! " +  LocalDateTime.now().format(df)).build();        
        }

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping1(@PathParam("id") String id) {
        return "ping1 ok!! " + " parametro: " + id + " " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

}
