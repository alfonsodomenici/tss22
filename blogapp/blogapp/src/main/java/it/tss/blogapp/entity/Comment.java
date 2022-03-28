/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.entity;

import it.tss.blogapp.adapters.UserTypeAdapter;
import it.tss.blogapp.adapters.PostTypeAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{

    @JsonbTypeAdapter(UserTypeAdapter.class)
    @ManyToOne(optional = false)
    private User author;

    @Column(nullable = false)
    private String msg;

    @JsonbTypeAdapter(PostTypeAdapter.class)
    @ManyToOne(optional = false)
    private Post post;
    
    /*
    getter setter
    */

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", author=" + author + ", msg=" + msg + ", post=" + post + '}';
    }
    
    
}
