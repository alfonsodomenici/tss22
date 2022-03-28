/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.adapters;

import it.tss.blogapp.control.PostStore;
import it.tss.blogapp.entity.Post;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author tss
 */
public class PostTypeAdapter implements JsonbAdapter<Post, JsonObject> {

    @Inject
    PostStore store;

    @Override
    public JsonObject adaptToJson(Post entity) throws Exception {
        return entity.toJsonSlice();
    }

    @Override
    public Post adaptFromJson(JsonObject json) throws Exception {
        if (!json.containsKey("id")) {
            return null;
        }
        return store.find(json.getJsonNumber("id").longValue()).orElseThrow(() -> new NotFoundException("PostTypeAdapter.adaptFromJson not found"));
    }

}
