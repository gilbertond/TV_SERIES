/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gilberto
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentid;

    @ManyToOne
    @JoinColumn(name = "episode")
    private Episode episode;

    @OneToOne
    @JoinColumn(name = "userid")
    private UserInfo userInfo;

    @Column(name = "datecommented")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecommented;

    @Column(name = "comment")
    private String comment;

    public Comment() {
    }

    public Comment(Episode episode, UserInfo userInfo, Date datecommented, String comment) {
        this.episode = episode;
        this.userInfo = userInfo;
        this.datecommented = datecommented;
        this.comment = comment;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getDatecommented() {
        return (Date)datecommented.clone();
    }

    public void setDatecommented(Date datecommented) {
        this.datecommented = (Date)datecommented.clone();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.episode);
        hash = 31 * hash + Objects.hashCode(this.userInfo);
        hash = 31 * hash + Objects.hashCode(this.comment);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.episode, other.episode)) {
            return false;
        }
        if (!Objects.equals(this.userInfo, other.userInfo)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        return true;
    }
}
