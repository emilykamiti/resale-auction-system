package com.resale.app.model.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.resale.app.view.helper.HtmlTableColHeader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
public class User extends BaseEntity {

    @Column(name = "userType")
    @Enumerated(EnumType.STRING)
    private UserType  userType;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    private String confirmPassword;

    @Transient
    private String oldPassword;
    
    public  User() {      
        this.userType = UserType.ADMIN; 
        this.userType = UserType.BIDDER;
    }

    public User(String username) {
        this.username = username;
    }

    public User(Long id, String username, String password) {
        setId(id);
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setRole(UserType userType) {
        this.userType = userType;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


}
