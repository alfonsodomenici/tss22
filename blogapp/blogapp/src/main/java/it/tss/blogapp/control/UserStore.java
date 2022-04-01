/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.control;

import it.tss.blogapp.SecurityEncoding;
import it.tss.blogapp.entity.User;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author tss
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class UserStore {

    @PersistenceContext
    EntityManager em;

    @Inject
    PostStore postStore;

    /**
     * restituisce tutti gli utenti presenti nel database
     * 
     * @return lista oggetti User
     */
    public List<User> all() {
        return em.createQuery("select e from User e order by e.lastName", User.class)
                .getResultList();
    }

    /**
     * restituisce tutti gli utenti presenti nel database in modo paginato
     * 
     * @param page numero di pagina
     * @param size dimensioni pagina
     * @return lista oggetti User
     */
    public List<User> allPaginated(int page, int size) {
        return em.createQuery("select e from User e order by e.lastName", User.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public Optional<User> find(Long id) {
        User found = em.find(User.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public User create(User entity){
        entity.setPwd(SecurityEncoding.shaHash(entity.getPwd()));
        return save(entity);
    }
    
    public User save(User entity) {
        User saved = em.merge(entity);
        return saved;
    }

    public void delete(Long id) {
        postStore.deleteByUser(id);
        em.remove(em.getReference(User.class, id));
    }
}
