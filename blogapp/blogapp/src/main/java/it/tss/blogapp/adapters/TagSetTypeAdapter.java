/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.adapters;

import it.tss.blogapp.control.TagStore;
import it.tss.blogapp.entity.Tag;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author tss
 */
public class TagSetTypeAdapter implements JsonbAdapter<Set<Tag>, Set<Long>> {

    @Inject
    TagStore store;
    
    @Override
    public Set<Long> adaptToJson(Set<Tag> tags) throws Exception {
        return tags.stream().map(Tag::getId).collect(Collectors.toSet());
    }

    @Override
    public Set<Tag> adaptFromJson(Set<Long> ids) throws Exception {
        System.out.println(ids);
        return ids.stream().map(v -> store.find(v).orElseThrow(() -> new NotFoundException())).collect(Collectors.toSet());
    }
    
}
