/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.control;

import it.tss.blogapp.entity.Comment;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author tss
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CommentStore {
    @PersistenceContext
    EntityManager em;
    
    public List<Comment> byPost(Long postId){
        return em.createQuery("select e from Comment e where e.post.id= :postId", Comment.class)
                .setParameter("postId", postId)
                .getResultList();
    }
    
    public Comment save(Comment entity){
        return em.merge(entity);
    }
    
    public Optional<Comment> find(Long id){
        Comment found = em.find(Comment.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
    public void delete(Long id){
        Comment found = find(id).orElseThrow(() -> new NotFoundException());
        em.remove(found);
    }

    public void deleteByPost(Long id) {
        byPost(id).stream().map(Comment::getId).forEach(this::delete);
    }
}
