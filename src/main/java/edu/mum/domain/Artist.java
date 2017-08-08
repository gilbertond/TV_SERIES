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
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author gilberto
 */
@Entity
@Table(name = "artist")
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artistid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "placeofbirth")
    private String placeofbirth;

    @Column(name = "biography")
    private String biography;

    @Lob
    @Column(name = "picture")
    @ElementCollection
    private final List<byte[]> pictures;

    public Artist() {
        this.pictures = new ArrayList<>();
    }

    public Artist(String firstname, String lastname, String placeofbirth, String biography, List<byte[]> pictures) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.placeofbirth = placeofbirth;
        this.biography = biography;
        this.pictures = new ArrayList<>();
        this.pictures.addAll(pictures);
    }

    public int getPicsCount() {
        return this.pictures.size();
    }

    public void addPicture(byte[] picBytes) {
        this.pictures.add(getPicsCount(), picBytes);
    }

    public void addPicture(List<byte[]> picBytes) {
        this.pictures.addAll(getPicsCount(), picBytes);
    }

    public Integer getArtistid() {
        return artistid;
    }

    public void setArtistid(Integer artistid) {
        this.artistid = artistid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<byte[]> getPictures() {
        return Collections.unmodifiableList(pictures);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.artistid);
        hash = 31 * hash + Objects.hashCode(this.firstname);
        hash = 31 * hash + Objects.hashCode(this.lastname);
        hash = 31 * hash + Objects.hashCode(this.placeofbirth);
        hash = 31 * hash + Objects.hashCode(this.biography);
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
        final Artist other = (Artist) obj;
        if (!Objects.equals(this.artistid, other.getArtistid())) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.getFirstname())) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.getLastname())) {
            return false;
        }
        if (!Objects.equals(this.placeofbirth, other.getPlaceofbirth())) {
            return false;
        }
        if (!Objects.equals(this.biography, other.getBiography())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Artist{" + "firstname=" + firstname + ", lastname=" + lastname + ", placeofbirth=" + placeofbirth + ", biography=" + biography 
                + ", pictures=" + pictures.size() + '}';
    }
}
