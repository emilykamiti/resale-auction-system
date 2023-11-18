package com.resale.app.model.entity;

import java.io.Serializable;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlFormField;

@HtmlForm(label = "User", url = "./user")
public class User implements Serializable {

    private Long id;

    @HtmlFormField(label = "user-username")
    private String username;

    @HtmlFormField(label = "password")
    private String password;

    @HtmlFormField(label = "confirm-password")
    private String confirmPassword;

    public User(){}

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
