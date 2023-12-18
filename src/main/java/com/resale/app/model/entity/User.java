package com.resale.app.model.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findUserByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = "findUserByUserId", query = "SELECT u FROM User u WHERE u.id = :id")
})

@DynamicInsert
@DynamicUpdate
public class User extends BaseEntity {

    @Column(name = "userType")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bid> bids = new ArrayList<>();

    @Transient
    private String confirmPassword;

    @Transient
    private String oldPassword;

    public User() {
        this.userType = UserType.BIDDER;
    }

    public User(@NotNull String username, @NotNull String email, @NotNull String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = UserType.BIDDER;
    }

    @Override
    public String toString() {
        return "User [userType=" + userType + ", username=" + username + ", email=" + email + ", password=" + password
                + ", bids=" + bids + ", confirmPassword=" + confirmPassword + ", oldPassword=" + oldPassword + "]";
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
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
