package com.github.kvb2univpitt.demo.secured.webapp.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * Dec 28, 2020 11:12:54 PM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Entity
@Table(name = "UserProfile")
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 7692185108240156648L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @JoinColumn(name = "app_user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AppUser appUser;

    public UserProfile() {
    }

    public UserProfile(AppUser appUser) {
        this.appUser = appUser;
    }

    public UserProfile(String firstName, String lastName, AppUser appUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}
