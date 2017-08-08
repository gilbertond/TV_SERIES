/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.domain;

import java.io.Serializable;
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

/**
 *
 * @author gilberto
 */

@Entity
@Table(name = "seriecast")
public class SerieCast implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer castid;
    
    @Column(name = "castname")
    private String castname;
    
    @ManyToOne
    @JoinColumn(name = "serie")
    private Serie serie;
    
    @OneToOne
    @JoinColumn(name = "artist")
    private final Artist artist;
    
    @Column(name = "roledescription")
    private String roledescription;

    public SerieCast() {
        this.artist = new Artist();
    }

    public SerieCast(String castname, Serie serie, Artist artist, String roledescription) {
        this.castname = castname;
        this.serie = serie;
        this.artist = artist;
        this.roledescription = roledescription;
    }

    public Integer getCastid() {
        return castid;
    }

    public void setCastid(Integer castid) {
        this.castid = castid;
    }

    public String getCastname() {
        return castname;
    }

    public void setCastname(String castname) {
        this.castname = castname;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getRoledescription() {
        return roledescription;
    }

    public void setRoledescription(String roledescription) {
        this.roledescription = roledescription;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Cast{" + "castname=" + castname + ", serie=" + serie + ", artist=" + artist + ", roledescription=" + roledescription + '}';
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.castid);
        hash = 31 * hash + Objects.hashCode(this.castname);
        hash = 31 * hash + Objects.hashCode(this.serie);
        hash = 31 * hash + Objects.hashCode(this.artist);
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
        final SerieCast other = (SerieCast) obj;
        if (!Objects.equals(this.castid, other.getCastid())) {
            return false;
        }
        if (!Objects.equals(this.castname, other.getCastname())) {
            return false;
        }
        if (!Objects.equals(this.serie, other.getSerie())) {
            return false;
        }
        if (!Objects.equals(this.artist, other.getArtist())) {
            return false;
        }
        return true;
    }
    
    
}
