/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gilberto
 */
@Entity
@Table(name = "season")
public class Season implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seasonid;

    @Column(name = "seasonnumber")
    private Integer seasonnumber;

    @OneToMany(mappedBy = "episode")
    private List<Episode> episodes;

    @ManyToOne
    @JoinColumn(name = "serie")
    private Serie serie;

    @Column(name = "description")
    private String description;

    @Column(name = "dateaired")
    @Temporal(TemporalType.DATE)
    private Date dateaired;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private final List<SerieCast> casts;

    public Season() {
        this.episodes = new ArrayList<>();
        this.casts = new ArrayList<>();
    }

    public Season(Integer seasonnumber, List<Episode> episodes, Serie serie, String description, Date dateaired, List<SerieCast> casts) {
        this.seasonnumber = seasonnumber;
        this.episodes = new ArrayList<>();
        this.episodes.addAll(episodes);
        this.serie = serie;
        this.description = description;
        this.dateaired = dateaired;
        this.casts = new ArrayList<>();
        this.casts.addAll(casts);
    }

    public int getCastsCount() {
        return this.casts.size();
    }

    public void addCast(SerieCast cast) {
        this.casts.add(getCastsCount(), cast);
    }

    public void addCast(List<SerieCast> casts) {
        this.casts.addAll(getCastsCount(), casts);
    }

    public int getEpisodesCount() {
        return this.episodes.size();
    }

    public void addEpisode(Episode episode) {
        this.episodes.add(getEpisodesCount(), episode);
    }

    public void addEpisode(List<Episode> episodes) {
        this.episodes.addAll(getEpisodesCount(), episodes);
    }

    public Integer getSeasonid() {
        return seasonid;
    }

    public void setSeasonid(Integer seasonid) {
        this.seasonid = seasonid;
    }

    public Integer getSeasonnumber() {
        return seasonnumber;
    }

    public void setSeasonnumber(Integer seasonnumber) {
        this.seasonnumber = seasonnumber;
    }

    public List<Episode> getEpisodes() {
        return Collections.unmodifiableList(episodes);
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateaired() {
        return (Date) dateaired.clone();
    }

    public void setDateaired(Date dateaired) {
        this.dateaired = (Date) dateaired.clone();
    }

    public List<SerieCast> getCasts() {
        return Collections.unmodifiableList(casts);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.seasonid);
        hash = 31 * hash + Objects.hashCode(this.seasonnumber);
        hash = 31 * hash + Objects.hashCode(this.serie);
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
        final Season other = (Season) obj;
        if (!Objects.equals(this.seasonid, other.getSeasonid())) {
            return false;
        }
        if (!Objects.equals(this.seasonnumber, other.getSeasonnumber())) {
            return false;
        }
        if (!Objects.equals(this.serie, other.getSerie())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Season{" + "seasonnumber=" + seasonnumber + ", episodes=" + episodes.size() + ", serie=" + serie
                + ", description=" + description + ", dateaired=" + dateaired + ", casts=" + casts.size() + '}';
    }
}
