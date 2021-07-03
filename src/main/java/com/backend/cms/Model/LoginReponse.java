package com.backend.cms.Model;

import java.lang.reflect.Type;
import java.util.List;

public class LoginReponse {
    private String id;
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private boolean status;
    private Role role;
    private List<Type> types;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }


}
