/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gilberto
 */
@Entity
@Table(name = "episode")
public class Episode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer episodeid;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Comment> comments;

    @Column(name = "episodenumber")
    private int episodenumber;

    @Column(name = "theme")
    private String theme;

    @ManyToOne
    @JoinColumn(name = "season")
    private Season season;

    public Episode() {
        this.comments = new ArrayList<>();
    }

    public Episode(List<Comment> comments, Season season, int episodenumber, String theme) {
        this.comments = new ArrayList<>();
        this.comments.addAll(comments);
        this.episodenumber = episodenumber;
        this.theme = theme;
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getCommentsCount() {
        return this.comments.size();
    }

    public void addComment(Comment comment) {
        this.comments.add(getCommentsCount(), comment);
    }

    public Integer getEpisodeid() {
        return episodeid;
    }

    public void setEpisodeid(Integer episodeid) {
        this.episodeid = episodeid;
    }

    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public int getEpisodenumber() {
        return episodenumber;
    }

    public void setEpisodenumber(int episodenumber) {
        this.episodenumber = episodenumber;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.episodeid);
        hash = 31 * hash + this.episodenumber;
        hash = 31 * hash + Objects.hashCode(this.theme);
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
        final Episode other = (Episode) obj;
        if (!Objects.equals(this.episodeid, other.getEpisodeid())) {
            return false;
        }
        if (this.episodenumber != other.getEpisodenumber()) {
            return false;
        }
        if (!Objects.equals(this.theme, other.getTheme())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Episode{" + "comments=" + comments.size() + ", episodenumber=" + episodenumber + ", theme=" + theme + '}';
    }
}
