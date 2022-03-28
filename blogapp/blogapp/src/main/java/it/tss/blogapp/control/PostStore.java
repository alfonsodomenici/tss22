/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.control;

import it.tss.blogapp.entity.Post;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author tss
 */
@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class PostStore {

    @PersistenceContext
    EntityManager em;

    public List<Post> all() {
        return em.createQuery("select e from Post e order by e.created DESC", Post.class)
                .getResultList();
    }

    public Optional<Post> find(Long id) {
        Post found = em.find(Post.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public List<Post> byUser(Long userId) {
        return em.createQuery("select e from Post e where e.author.id= :userId order by e.created DESC", Post.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public Post save(Post entity) {
        return em.merge(entity);
    }

}
