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
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author gilberto
 */
@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @ElementCollection
    private List<String> roles;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    @ColumnDefault("true")
    private Boolean active;

    public UserInfo() {
        this.roles = new ArrayList<>();
        this.roles.add(0, "ROLE_USER");
    }

    public UserInfo(String firstname, String lastname, List<String> roles, String username, String password, Boolean active) {
        this.roles = new ArrayList<>();
        this.firstname = firstname;
        this.lastname = lastname;        
        this.username = username;
        this.password = password;
        this.active = active;
        
        this.roles = new ArrayList<>();
        this.roles.add(0, "ROLE_USER");
        this.roles.addAll(roles);
    }

    public void addRole(String role) {
        this.roles.add(this.roles.size(), role);
    }

    public void addRoles(List<String> roles) {
        this.roles.addAll(this.roles.size(), roles);
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public List<String> getRoles() {
        return Collections.unmodifiableList(roles);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", roles=" + roles + ", username=" + username + ", password=******, active=" + active + '}';
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.userid);
        hash = 31 * hash + Objects.hashCode(this.firstname);
        hash = 31 * hash + Objects.hashCode(this.lastname);
        hash = 31 * hash + Objects.hashCode(this.username);
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
        final UserInfo other = (UserInfo) obj;
        if (!Objects.equals(this.userid, other.userid)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
}
