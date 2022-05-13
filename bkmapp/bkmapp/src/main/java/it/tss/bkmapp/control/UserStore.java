/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.control;

import it.tss.bkmapp.SecurityEncoding;
import it.tss.bkmapp.boundary.Credential;
import it.tss.bkmapp.entity.Bkm;
import it.tss.bkmapp.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author tss
 */
@Named("userstore")
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class UserStore {

    @PersistenceContext
    EntityManager em;

    @Inject
    BkmStore bkmStore;

    @Inject
    @ConfigProperty(name = "query.result.max", defaultValue = "10")
    int defaultPageSize;

    /**
     * restituisce tutti gli utenti presenti nel database
     *
     * @return lista oggetti User
     */
    public List<User> all() {
        return em.createQuery("select e from User e order by e.lastName", User.class)
                .getResultList();
    }

    public List<User> search(String fname, String lname, Integer page, Integer size) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root)
                .where(searchPredicate(cb, root, fname, lname));
        int pageSize = size == null ? defaultPageSize : size;
        return em.createQuery(query)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public long searchCount(String fname, String lname) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root root = query.from(User.class);
        query.select(cb.count(root)).where(searchPredicate(cb, root, fname, lname));
        return em.createQuery(query).getSingleResult();
    }

    public Predicate searchPredicate(CriteriaBuilder cb, Root<User> root, String fname, String lname) {
        Predicate result = cb.conjunction();

        if (fname != null && !fname.isBlank()) {
            result = cb.and(result, cb.like(root.get("firstName"), "%" + fname + "%"));
        }
        if (lname != null && !lname.isBlank()) {
            result = cb.and(result, cb.like(root.get("lastName"), "%" + lname + "%"));
        }


        return result;
    }
    
    public Optional<User> find(Long id) {
        User found = em.find(User.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public User create(User entity) {
        entity.setPwd(SecurityEncoding.shaHash(entity.getPwd()));
        return save(entity);
    }

    public User save(User entity) {
        User saved = em.merge(entity);
        return saved;
    }

    public void delete(Long id) {
        bkmStore.deleteByUser(id);
        em.remove(em.getReference(User.class, id));
    }

    public Optional<User> login(Credential credential) {
        try {
            return Optional.of(em.createQuery("select e from User e where e.email= :usr and e.pwd= :pwd", User.class)
                    .setParameter("usr", credential.usr)
                    .setParameter("pwd", SecurityEncoding.shaHash(credential.pwd))
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
