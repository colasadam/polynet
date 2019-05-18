package com.polytech.polynetwork.application;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "users")
public class User {

    @Id
    private String username;
    @Column(name = "password")
    private String password;
    @Column (name="enabled")
    private int enabled;

    @OneToMany
    @JoinColumn(name = "username")
    private List<Authority> authorities;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled= 1;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public User(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
