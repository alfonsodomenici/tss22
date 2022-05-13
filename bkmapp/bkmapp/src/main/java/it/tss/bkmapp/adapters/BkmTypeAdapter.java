/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.adapters;

import it.tss.bkmapp.control.BkmStore;
import it.tss.bkmapp.entity.Bkm;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author tss
 */
public class BkmTypeAdapter implements JsonbAdapter<Bkm, JsonObject> {

    @Inject
    BkmStore store;

    @Override
    public JsonObject adaptToJson(Bkm entity) throws Exception {
        return entity.toJsonSlice();
    }

    @Override
    public Bkm adaptFromJson(JsonObject json) throws Exception {
        if (!json.containsKey("id")) {
            return null;
        }
        return store.find(json.getJsonNumber("id").longValue()).orElseThrow(() -> new NotFoundException("BkmTypeAdapter.adaptFromJson not found"));
    }

}
