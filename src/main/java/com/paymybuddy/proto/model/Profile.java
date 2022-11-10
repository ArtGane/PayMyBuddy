package com.paymybuddy.proto.model;

import com.paymybuddy.proto.model.roles.Role;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Profile {

    public Profile() {
    }

    public Profile(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Profile(LocalDateTime creationDate, String lastname, String firstname, String email, String password, List<Profile> friends, Account account) {
        this.creationDate = creationDate;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.friends = friends;
        this.account = account;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime creationDate;

    @Length(max = 100)
    private String lastname;

    @Length(max = 100)
    private String firstname;

    @Email
    @NotBlank
    @Column
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @ManyToMany
    private List<Profile> friends;

    @OneToOne
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    ///////////////////////////////////////////Guetters & setters///////////////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public List<Profile> getFriends() {
        return friends;
    }

    public void setFriends(List<Profile> friends) {
        this.friends = friends;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}