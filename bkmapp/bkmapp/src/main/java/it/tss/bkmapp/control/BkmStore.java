/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.control;

import it.tss.bkmapp.entity.Bkm;
import it.tss.bkmapp.entity.Tag;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class BkmStore {

    @PersistenceContext
    EntityManager em;

    @Inject
    TagStore tagStore;

    @Inject
    @ConfigProperty(name = "query.result.max", defaultValue = "10")
    int defaultPageSize;

    public List<Bkm> all() {
        return em.createQuery("select e from Bkm e order by e.created DESC", Bkm.class)
                .getResultList();
    }

    public List<Bkm> search(Long userId, String descr, String tag, Integer page, Integer size) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bkm> query = cb.createQuery(Bkm.class);
        Root<Bkm> root = query.from(Bkm.class);
        query.select(root)
                .where(searchPredicate(cb, root, userId, descr, tag));
        int pageSize = size == null ? defaultPageSize : size;
        return em.createQuery(query)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public long searchCount(Long userId, String descr, String tag) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root root = query.from(Bkm.class);
        query.select(cb.count(root)).where(searchPredicate(cb, root, userId, descr, tag));
        return em.createQuery(query).getSingleResult();
    }

    public Predicate searchPredicate(CriteriaBuilder cb, Root<Bkm> root, Long userId, String descr, String tag) {
        Predicate result = cb.conjunction();
        if (userId != null) {
            result = cb.and(result, cb.equal(root.get("owner").get("id"), userId));
        }
        if (descr != null && !descr.isBlank()) {
            result = cb.and(result, cb.like(root.get("description"), "%" + descr + "%"));
        }
        if (tag != null && !tag.isBlank()) {
            Optional<Tag> optTag = tagStore.byName(tag);
            result = cb.and(result, optTag.isEmpty() ? cb.isTrue(cb.literal(false)) : cb.isMember(optTag.get(), root.get("tags")));
        }
        
        result = cb.or(result,cb.isTrue(root.get("shared")));
        
        return result;
    }

    public Optional<Bkm> find(Long id) {
        Bkm found = em.find(Bkm.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public List<Bkm> byUser(Long userId) {
        return em.createNamedQuery(Bkm.SEARCH_BY_USER)
                .setParameter("userId", userId)
                .getResultList();
    }

    public Bkm save(Bkm entity) {
        return em.merge(entity);
    }

    public void addTag(Bkm found, String tag) {
        Bkm toupdate = find(found.getId()).get();
        Tag saved = tagStore.saveIfNotExists(tag);
        toupdate.getTags().add(saved);
        save(toupdate);
    }

    public void removeTag(Long id, String tag) {
        final Bkm toupdate = find(id).get();
        Optional<Tag> found = tagStore.byName(tag);
        if (found.isPresent()) {
            toupdate.getTags().remove(found.get());
            save(toupdate);
        }
    }

    public void deleteByUser(Long id) {
        byUser(id).stream().map(Bkm::getId).forEach(this::delete);
    }

    public void delete(Long id) {
        em.remove(em.getReference(Bkm.class, id));
    }

}
