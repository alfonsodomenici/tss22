/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.entity;

import it.tss.bkmapp.adapters.UserTypeAdapter;
import it.tss.bkmapp.boundary.BkmsResource;
import it.tss.bkmapp.boundary.UsersResource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(name = Bkm.SEARCH_BY_USER,
            query = "select e from Bkm e where e.owner.id= :userId order by e.created DESC"),
    
})


@Entity
@Table(name = "bkm")
public class Bkm extends BaseEntity {

    public static final String SEARCH_BY_USER = "Bkm.searchByUser";
    
    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne(optional = false)
    private User owner;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private boolean shared = false;
    
    @JsonbTransient
    @ManyToMany
    @JoinTable(name = "bkm_tag",
            joinColumns = @JoinColumn(name = "bkm_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new TreeSet<>();

    public JsonObject toJsonSlice() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("description", this.description)
                .build();
    }

    /*
    getter setter
     */
    public LocalDateTime getCreated() {
        return created;
    }

    @JsonbTransient
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @JsonbTypeAdapter(UserTypeAdapter.class)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getLink() {
        return UriBuilder.fromResource(BkmsResource.class)
                .path(BkmsResource.class, "find")
                .build(this.id).toString();
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    
    @Override
    public String toString() {
        return "Bkm{" + "id=" + id + ", created=" + created + ", author=" + owner + ", title=" + description + ", body=" + url + ", tags=" + tags + '}';
    }

}
