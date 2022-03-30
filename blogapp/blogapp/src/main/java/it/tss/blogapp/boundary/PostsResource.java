/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.boundary;

import it.tss.blogapp.control.CommentStore;
import it.tss.blogapp.control.PostStore;
import it.tss.blogapp.control.TagStore;
import it.tss.blogapp.entity.Comment;
import it.tss.blogapp.entity.Post;
import it.tss.blogapp.entity.Tag;
import it.tss.blogapp.entity.User;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("/posts")
public class PostsResource {

    @Inject
    PostStore store;
    
    @Inject
    CommentStore commentStore;
        
    @Inject
    TagStore tagStore;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> all() {
        return store.all();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post find(@PathParam("id") Long id) {
        return store.find(id).orElseThrow(() -> new NotFoundException());
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Post update(@PathParam("id") Long id, @Valid Post entity) {
        throw new UnsupportedOperationException();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> comments(@PathParam("id") Long id) {
        return commentStore.byPost(id);
    }

    @POST
    @Path("{id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createComment(@PathParam("id") Long id, @Valid Comment entity) {
        commentStore.save(entity);
    }

    @GET
    @Path("{id}/tags")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Tag> tags(@PathParam("id") Long id) {
        return tagStore.byPost(id);
    }

    @PATCH
    @Path("{id}/tags")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addTag(@PathParam("id") Long id, @NotBlank String tag) {
        Post found = store.find(id).orElseThrow(() -> new NotFoundException());
        store.addTag(found,tag);
    }

    @DELETE
    @Path("{id}/tags")
    @Consumes(MediaType.TEXT_PLAIN)
    public void removeTag(@PathParam("id") Long id, String tag) {
        store.removeTag(id,tag);
    }
}
