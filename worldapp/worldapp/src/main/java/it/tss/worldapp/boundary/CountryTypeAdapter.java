/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.worldapp.boundary;

import it.tss.worldapp.entity.Country;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author tss
 */
public class CountryTypeAdapter implements JsonbAdapter<Country, JsonObject> {

    @PersistenceContext
    EntityManager em;

    @Override
    public JsonObject adaptToJson(Country entity) throws Exception {
        return entity.toJsonSlice();
    }

    @Override
    public Country adaptFromJson(JsonObject json) throws Exception {
        if (!json.containsKey("code")) {
            return null;
        }
        return em.find(Country.class,json.getString("code"));
    }

}
