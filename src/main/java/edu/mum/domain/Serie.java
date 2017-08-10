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
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gilberto
 */
@Entity
@Table(name = "serie")
public class Serie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serieid;

    @Column(name = "seriename")
    private String seriename;

    @Lob
    @Column(name = "poster")
    private byte[] poster;

    @Column(name = "releaseyear")
    private int releaseyear;

    @Column(name = "description")
    private String description;

    @Column(name = "studio")
    private String studio;

    @Column(name = "director")
    private String director;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)//, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SerieCast> serieCast;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)//, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Season> seasons;

    @Embedded
    @Enumerated
    private Genre genre;

    public Serie() {
        this.seasons = new ArrayList<>();
        this.serieCast = new ArrayList<>();
        this.rating = new ArrayList<>();
    }

    public Serie(String seriename, byte[] poster, int releaseyear, String description, String studio, String director, List<SerieCast> serieCast, List<Season> seasons, Genre genre, List<Float> rating) {
        this.seriename = seriename;
        this.poster = poster;
        this.releaseyear = releaseyear;
        this.description = description;
        this.studio = studio;
        this.director = director;
        this.serieCast = serieCast;
        this.seasons = seasons;
        this.genre = genre;
        this.rating = rating;
    }
    
    @Column(name = "rating")
    @ElementCollection
    private List<Float> rating;

    public Integer getSerieid() {
        return serieid;
    }

    public void setSerieid(Integer serieid) {
        this.serieid = serieid;
    }

    public String getSeriename() {
        return seriename;
    }

    public void setSeriename(String seriename) {
        this.seriename = seriename;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public int getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(int releaseyear) {
        this.releaseyear = releaseyear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<SerieCast> getSerieCast() {
        return Collections.unmodifiableList(serieCast);
    }

    public int getCastCount(){
        return this.serieCast.size();
    }
    
    public void addSerieCast(List<SerieCast> serieCast) {
        this.serieCast.addAll(getCastCount(), serieCast);
    }
    
    public void addSerieCast(SerieCast serieCast) {
        this.serieCast.add(getCastCount(), serieCast);
    }

    public List<Season> getSeasons() {
        return Collections.unmodifiableList(seasons);
    }
    
    public int getSeasonsCount(){
        return this.serieCast.size();
    }

    public void addSeasons(List<Season> seasons) {
        this.seasons.addAll(getSeasonsCount(), seasons);
    }
    
    public void addSeasons(Season season) {
        this.seasons.add(getSeasonsCount(), season);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Float> getRating() {
        return Collections.unmodifiableList(rating);
    }

    public void setRating(List<Float> rating) {
        this.rating = rating;
    }
    
    
    public float getRatingScore(){
        float sum = 0f;
        sum = this.getRating().stream().map((q) -> q).reduce(sum, (accumulator, _item) -> accumulator + _item);
        return sum/this.getRating().size();
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.serieid);
        hash = 31 * hash + Objects.hashCode(this.seriename);
        hash = 31 * hash + this.releaseyear;
        hash = 31 * hash + Objects.hashCode(this.genre);
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
        final Serie other = (Serie) obj;
        if (!Objects.equals(this.serieid, other.getSerieid())) {
            return false;
        }
        if (!Objects.equals(this.seriename, other.getSeriename())) {
            return false;
        }
        if (this.releaseyear != other.getReleaseyear()) {
            return false;
        }
        if (this.genre != other.getGenre()) {
            return false;
        }
        return true;
    }
    
    
}

@Embeddable
enum Genre {
    ACTION, DRAMA, DETECTIVE, HORROR, ADVENTURE
}
