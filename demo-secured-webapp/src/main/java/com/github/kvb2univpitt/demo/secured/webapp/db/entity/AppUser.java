package com.github.kvb2univpitt.demo.secured.webapp.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * Dec 28, 2020 7:17:04 PM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Entity
@Table(name = "AppUser", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})
})
public class AppUser implements Serializable {

    private static final long serialVersionUID = -6787400018743517917L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String username;

    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String password;

    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public AppUser() {
    }

    public AppUser(String username, String password, Date created) {
        this.username = username;
        this.password = password;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
